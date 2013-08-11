package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DBMS2 extends Activity implements OnClickListener {

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
			Intent a1 = new Intent(DBMS2.this, Webv.class);
			a1.putExtras(b1);
			startActivity(a1);
			break;
		case R.id.progdown:
			Bundle b2 = new Bundle();
			b2.putString("key", url);
			Intent a2 = new Intent(DBMS2.this, AndroidFileDownloader.class);
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

		pn = "PROGRAM 2";
		pd = "The following relations keep track of airline flight information:"
				+ System.getProperty("line.separator")
				+ "Flights (no: integer, from: string, to: string, distance: integer, Departs: time, arrives: time, price: real)"
				+ System.getProperty("line.separator")
				+ "Aircraft (aid: integer, aname: string, cruisingrange: integer)"
				+ System.getProperty("line.separator")
				+ "Certified (eid: integer, aid: integer)"
				+ System.getProperty("line.separator")
				+ "Employees (eid: integer, ename: string, salary: integer)"
				+ System.getProperty("line.separator")
				+ "Note that the Employees relation describes pilots and other kinds of employees as well;"
				+ System.getProperty("line.separator")
				+ "Every pilot is certified for some aircraft, and only pilots are certified to fly."
				+ System.getProperty("line.separator")
				+ "Write each of the following queries in SQL."
				+ System.getProperty("line.separator")
				+ "i. Find the names of aircraft such that all pilots certified to operate them have salaries more than Rs.80, 000."
				+ System.getProperty("line.separator")
				+ "ii. For each pilot who is certified for more than three aircrafts, find the eid and the maximum cruisingrange of the aircraft for which she or he is certified."
				+ System.getProperty("line.separator")
				+ "iii. Find the names of pilots whose salary is less than the price of the cheapest route from Bengaluru to Frankfurt."
				+ System.getProperty("line.separator")
				+ "iv. For all aircraft with cruisingrange over 1000 Kms, .find the name of the aircraft and the average salary of all pilots certified for this aircraft."
				+ System.getProperty("line.separator")
				+ "v. Find the names of pilots certified for some Boeing aircraft."
				+ System.getProperty("line.separator")
				+ "vi. Find the aids of all aircraft that can be used on routes from Bengaluru to New Delhi.";
		url = "http://vtulabs.comeze.com/DBMS_LAB/2.FLIGHT";

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
