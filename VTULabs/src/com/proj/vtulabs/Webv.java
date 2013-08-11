package com.proj.vtulabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webv extends Activity {

	String url;
	WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webv);

		Bundle b1 = getIntent().getExtras();
		url = b1.getString("key");

		webview = (WebView) findViewById(R.id.webview);

		webview.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				webview.loadUrl("file:///android_asset/myerrorpage.html");

			}
		});
		webview.loadUrl(url);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cool_menu, menu);
		return true;
	}

}
