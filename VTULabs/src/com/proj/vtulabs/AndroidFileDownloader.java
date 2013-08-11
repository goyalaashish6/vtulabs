package com.proj.vtulabs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

@SuppressLint("HandlerLeak")
public class AndroidFileDownloader extends Activity {

	public static final int MESSAGE_DOWNLOAD_STARTED = 1000;
	public static final int MESSAGE_DOWNLOAD_COMPLETE = 1001;
	public static final int MESSAGE_UPDATE_PROGRESS_BAR = 1002;
	public static final int MESSAGE_DOWNLOAD_CANCELED = 1003;
	public static final int MESSAGE_CONNECTING_STARTED = 1004;
	public static final int MESSAGE_ENCOUNTERED_ERROR = 1005;

	private AndroidFileDownloader thisActivity;
	private Thread downloaderThread;
	private ProgressDialog progressDialog;

	String urlInput;

	public Handler activityHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MESSAGE_UPDATE_PROGRESS_BAR:
				if (progressDialog != null) {
					int currentProgress = msg.arg1;
					progressDialog.setProgress(currentProgress);
				}
				break;

			case MESSAGE_CONNECTING_STARTED:
				if (msg.obj != null && msg.obj instanceof String) {
					String url = (String) msg.obj;
					if (url.length() > 16) {
						String tUrl = url.substring(0, 15);
						tUrl += "...";
						url = tUrl;
					}
					String pdTitle = thisActivity
							.getString(R.string.progress_dialog_title_connecting);
					String pdMsg = thisActivity
							.getString(R.string.progress_dialog_message_prefix_connecting);
					pdMsg += " " + url;

					dismissCurrentProgressDialog();
					progressDialog = new ProgressDialog(thisActivity);
					progressDialog.setTitle(pdTitle);
					progressDialog.setMessage(pdMsg);
					progressDialog
							.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					progressDialog.setIndeterminate(true);
					Message newMsg = Message.obtain(this,
							MESSAGE_DOWNLOAD_CANCELED);
					progressDialog.setCancelMessage(newMsg);
					progressDialog.show();
				}
				break;

			case MESSAGE_DOWNLOAD_STARTED:
				if (msg.obj != null && msg.obj instanceof String) {
					int maxValue = msg.arg1;
					String fileName = (String) msg.obj;
					String pdTitle = thisActivity
							.getString(R.string.progress_dialog_title_downloading);
					String pdMsg = thisActivity
							.getString(R.string.progress_dialog_message_prefix_downloading);
					pdMsg += " " + fileName;

					dismissCurrentProgressDialog();
					progressDialog = new ProgressDialog(thisActivity);
					progressDialog.setTitle(pdTitle);
					progressDialog.setMessage(pdMsg);
					progressDialog
							.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					progressDialog.setProgress(0);
					progressDialog.setMax(maxValue);
					Message newMsg = Message.obtain(this,
							MESSAGE_DOWNLOAD_CANCELED);
					progressDialog.setCancelMessage(newMsg);
					progressDialog.setCancelable(true);
					progressDialog.show();
				}
				break;

			case MESSAGE_DOWNLOAD_COMPLETE:
				dismissCurrentProgressDialog();
				displayMessage(getString(R.string.user_message_download_complete));
				break;
			case MESSAGE_DOWNLOAD_CANCELED:
				if (downloaderThread != null) {
					downloaderThread.interrupt();
				}
				dismissCurrentProgressDialog();
				displayMessage(getString(R.string.user_message_download_canceled));
				break;

			case MESSAGE_ENCOUNTERED_ERROR:
				if (msg.obj != null && msg.obj instanceof String) {
					String errorMessage = (String) msg.obj;
					dismissCurrentProgressDialog();
					displayMessage(errorMessage);
				}
				break;

			default:
				break;
			}
		}
	};

	public void dismissCurrentProgressDialog() {
		if (progressDialog != null) {
			progressDialog.hide();
			progressDialog.dismiss();
			progressDialog = null;
		}
	}

	public void displayMessage(String message) {
		if (message != null) {
			Toast.makeText(thisActivity, message, Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		thisActivity = this;
		downloaderThread = null;
		progressDialog = null;
		Bundle b = getIntent().getExtras();
		urlInput = b.getString("key");
		downloaderThread = new DownloaderThread(thisActivity, urlInput);
		downloaderThread.start();

	}
}