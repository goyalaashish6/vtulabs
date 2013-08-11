package com.proj.vtulabs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.os.Environment;
import android.os.Message;

public class DownloaderThread extends Thread {
	private static final int DOWNLOAD_BUFFER_SIZE = 4096;

	private AndroidFileDownloader parentActivity;
	private String downloadUrl;

	public DownloaderThread(AndroidFileDownloader inParentActivity, String inUrl) {
		downloadUrl = "";
		if (inUrl != null) {
			downloadUrl = inUrl;
		}
		parentActivity = inParentActivity;
	}

	@Override
	public void run() {
		URL url;
		URLConnection conn;
		int fileSize, lastSlash;
		String fileName;
		BufferedInputStream inStream;
		BufferedOutputStream outStream;
		File outFile;
		FileOutputStream fileStream;
		Message msg;

		msg = Message.obtain(parentActivity.activityHandler,
				AndroidFileDownloader.MESSAGE_CONNECTING_STARTED, 0, 0,
				downloadUrl);
		parentActivity.activityHandler.sendMessage(msg);

		try {
			url = new URL(downloadUrl);
			conn = url.openConnection();
			conn.setUseCaches(false);
			fileSize = conn.getContentLength();

			lastSlash = url.toString().lastIndexOf('/');
			fileName = "file.bin";
			if (lastSlash >= 0) {
				fileName = url.toString().substring(lastSlash + 1);
			}
			if (fileName.equals("")) {
				fileName = "file.bin";
			}

			int fileSizeInKB = fileSize / 1024;
			msg = Message.obtain(parentActivity.activityHandler,
					AndroidFileDownloader.MESSAGE_DOWNLOAD_STARTED,
					fileSizeInKB, 0, fileName);
			parentActivity.activityHandler.sendMessage(msg);

			inStream = new BufferedInputStream(conn.getInputStream());
			outFile = new File(Environment.getExternalStorageDirectory() + "/"
					+ fileName);
			fileStream = new FileOutputStream(outFile);
			outStream = new BufferedOutputStream(fileStream,
					DOWNLOAD_BUFFER_SIZE);
			byte[] data = new byte[DOWNLOAD_BUFFER_SIZE];
			int bytesRead = 0, totalRead = 0;
			while (!isInterrupted()
					&& (bytesRead = inStream.read(data, 0, data.length)) >= 0) {
				outStream.write(data, 0, bytesRead);

				totalRead += bytesRead;
				int totalReadInKB = totalRead / 1024;
				msg = Message.obtain(parentActivity.activityHandler,
						AndroidFileDownloader.MESSAGE_UPDATE_PROGRESS_BAR,
						totalReadInKB, 0);
				parentActivity.activityHandler.sendMessage(msg);
			}

			outStream.close();
			fileStream.close();
			inStream.close();

			if (isInterrupted()) {
				outFile.delete();
			} else {
				msg = Message.obtain(parentActivity.activityHandler,
						AndroidFileDownloader.MESSAGE_DOWNLOAD_COMPLETE);
				parentActivity.activityHandler.sendMessage(msg);
			}
		} catch (MalformedURLException e) {
			String errMsg = parentActivity
					.getString(R.string.error_message_bad_url);
			msg = Message.obtain(parentActivity.activityHandler,
					AndroidFileDownloader.MESSAGE_ENCOUNTERED_ERROR, 0, 0,
					errMsg);
			parentActivity.activityHandler.sendMessage(msg);
		} catch (FileNotFoundException e) {
			String errMsg = parentActivity
					.getString(R.string.error_message_file_not_found);
			msg = Message.obtain(parentActivity.activityHandler,
					AndroidFileDownloader.MESSAGE_ENCOUNTERED_ERROR, 0, 0,
					errMsg);
			parentActivity.activityHandler.sendMessage(msg);
		} catch (Exception e) {
			String errMsg = parentActivity
					.getString(R.string.error_message_general);
			msg = Message.obtain(parentActivity.activityHandler,
					AndroidFileDownloader.MESSAGE_ENCOUNTERED_ERROR, 0, 0,
					errMsg);
			parentActivity.activityHandler.sendMessage(msg);
		}
	}

}