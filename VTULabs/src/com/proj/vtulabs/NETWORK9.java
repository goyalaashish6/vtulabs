package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NETWORK9 extends Activity implements OnClickListener {

	TextView name, desc;
	Button view, down;
	String pn, pd, url;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.progview:
			Bundle b1 = new Bundle();
			b1.putString("key", url);
			Intent a1 = new Intent(NETWORK9.this, Webv.class);
			a1.putExtras(b1);
			startActivity(a1);
			break;
		case R.id.progdown:
			Bundle b2 = new Bundle();
			b2.putString("key", url);
			Intent a2 = new Intent(NETWORK9.this, AndroidFileDownloader.class);
			a2.putExtras(b2);
			startActivity(a2);

			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prog);

		pn = "PROGRAM 9";
		pd = "Using TCP/IP sockets, write a client � server program to make the client send the file name and to make the server send back the contents of the requested file if present.";
		url = "http://vtulabs.comeze.com/Networks_LAB/9.CLISER.cpp";

		down = (Button) findViewById(R.id.progdown);
		view = (Button) findViewById(R.id.progview);
		name = (TextView) findViewById(R.id.progname);
		desc = (TextView) findViewById(R.id.progdesc);
		down.setOnClickListener(this);
		view.setOnClickListener(this);
		name.setText(pn);
		desc.setText(pd);
	}

}
