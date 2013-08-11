package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DS13 extends Activity implements OnClickListener {

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
			Intent a1 = new Intent(DS13.this, Webv.class);
			a1.putExtras(b1);
			startActivity(a1);
			break;
		case R.id.progdown:
			Bundle b2 = new Bundle();
			b2.putString("key", url);
			Intent a2 = new Intent(DS13.this, AndroidFileDownloader.class);
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

		pn = "PROGRAM 13";
		pd = "Design, develop, and execute a program in C++ to create a class called OCTAL, which has the characteristics of an octal number."
				+ System.getProperty("line.separator")
				+ "Implement the following operations by writing an appropriate constructor and an overloaded operator +."
				+ System.getProperty("line.separator")
				+ "i. OCTAL h = x; where x is an integer"
				+ System.getProperty("line.separator")
				+ "ii. int y = h + k ; where h is an OCTAL object and k is an integer."
				+ System.getProperty("line.separator")
				+ "Display the OCTAL result by overloading the operator <<. Also display the values of h and y.";
		url = "http://vtulabs.comeze.com/DS_LAB/13.OCTAL.cpp";

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
