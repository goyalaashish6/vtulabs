package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SS_OS5b extends Activity implements OnClickListener {

	TextView name, desc;
	Button view1, down1, view2, down2;
	String pn, pd, url1, url2;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.progview1:
			Bundle b1 = new Bundle();
			b1.putString("key", url1);
			Intent a1 = new Intent(SS_OS5b.this, Webv.class);
			a1.putExtras(b1);
			startActivity(a1);
			break;
		case R.id.progdown1:
			Bundle b2 = new Bundle();
			b2.putString("key", url1);
			Intent a2 = new Intent(SS_OS5b.this, AndroidFileDownloader.class);
			a2.putExtras(b2);
			startActivity(a2);
			break;
		case R.id.progview2:
			Bundle b3 = new Bundle();
			b3.putString("key", url2);
			Intent a3 = new Intent(SS_OS5b.this, Webv.class);
			a3.putExtras(b3);
			startActivity(a3);
			break;
		case R.id.progdown2:
			Bundle b4 = new Bundle();
			b4.putString("key", url2);
			Intent a4 = new Intent(SS_OS5b.this, AndroidFileDownloader.class);
			a4.putExtras(b4);
			startActivity(a4);
			break;

		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prog2);

		pn = "PROGRAM 5b";
		pd = "Program to recognize strings ‘aaab’, ‘abbb’, ‘ab’ and ‘a’ using the grammar (anbn, n>= 0).";
		url1 = "http://vtulabs.comeze.com/SS&OS_LAB/5b.anbn.l";
		url2 = "http://vtulabs.comeze.com/SS&OS_LAB/5b.anbn.y";

		down1 = (Button) findViewById(R.id.progdown1);
		view1 = (Button) findViewById(R.id.progview1);
		down2 = (Button) findViewById(R.id.progdown2);
		view2 = (Button) findViewById(R.id.progview2);
		name = (TextView) findViewById(R.id.progname);
		desc = (TextView) findViewById(R.id.progdesc);
		down1.setOnClickListener(this);
		view1.setOnClickListener(this);
		down2.setOnClickListener(this);
		view2.setOnClickListener(this);
		name.setText(pn);
		desc.setText(pd);
	}

}