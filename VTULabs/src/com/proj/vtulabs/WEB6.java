package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WEB6 extends Activity implements OnClickListener {

	TextView name, desc;
	Button down;
	String pn, pd, url;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.progdown:
			Bundle b2 = new Bundle();
			b2.putString("key", url);
			Intent a2 = new Intent(WEB6.this, AndroidFileDownloader.class);
			a2.putExtras(b2);
			startActivity(a2);

			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prog1);

		pn = "PROGRAM 6";
		pd = "a) Write a Perl program to accept the User Name and display a greeting message randomly chosen from a list of 4 greeting messages."
				+ System.getProperty("line.separator")
				+ "b) Write a Perl program to keep track of the number of visitors visiting the web page and to display this count of visitors, with proper headings.";

		url = "http://vtulabs.comeze.com/WP_LAB/6.Prog6.zip";

		down = (Button) findViewById(R.id.progdown);

		name = (TextView) findViewById(R.id.progname);
		desc = (TextView) findViewById(R.id.progdesc);
		down.setOnClickListener(this);
		name.setText(pn);
		desc.setText(pd);
	}

}
