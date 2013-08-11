package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WEB1 extends Activity implements OnClickListener {

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
			Intent a1 = new Intent(WEB1.this, Webv.class);
			a1.putExtras(b1);
			startActivity(a1);
			break;

		case R.id.progdown:

			Bundle b2 = new Bundle();
			b2.putString("key", url);
			Intent a2 = new Intent(WEB1.this, AndroidFileDownloader.class);
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

		pn = "PROGRAM 1";
		pd = "Develop and demonstrate a XHTML file that includes Javascript script for the following problems:"
				+ System.getProperty("line.separator")
				+ "a) Input: A number n obtained using prompt"
				+ System.getProperty("line.separator")
				+ "Output: The first n Fibonacci numbers"
				+ System.getProperty("line.separator")
				+ "b) Input: A number n obtained using prompt"
				+ System.getProperty("line.separator")
				+ "Output: A table of numbers from 1 to n and their squares using alert";
		url = "http://vtulabs.comeze.com/WP_LAB/1.Prog1";

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