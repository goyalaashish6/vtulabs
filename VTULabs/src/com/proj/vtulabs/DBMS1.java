package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DBMS1 extends Activity implements OnClickListener {

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
			Intent a1 = new Intent(DBMS1.this, Webv.class);
			a1.putExtras(b1);
			startActivity(a1);
			break;

		case R.id.progdown:

			Bundle b2 = new Bundle();
			b2.putString("key", url);
			Intent a2 = new Intent(DBMS1.this, AndroidFileDownloader.class);
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
		pd = "Consider the following relations:"
				+ System.getProperty("line.separator")
				+ "Student (snum: integer, sname: string, major: string, level: string,age: integer)"
				+ System.getProperty("line.separator")
				+ "Class (name: string, meets at: string, room: string, d: integer)"
				+ System.getProperty("line.separator")
				+ "Enrolled (snum: integer, cname: string)"
				+ System.getProperty("line.separator")
				+ "Faculty (fid: integer, fname: string, deptid: integer)"
				+ System.getProperty("line.separator")
				+ "The meaning of these relations is straightforward; for example, Enrolled has one record per student-class pair such that the student is enrolled in the class. Level is a two character code with 4 different values (example: Junior: JR etc)"
				+ System.getProperty("line.separator")
				+ "Write the following queries in SQL. No duplicates should be printed in any of the answers."
				+ System.getProperty("line.separator")
				+ "i. Find the names of all Juniors (level = JR) who are enrolled in a class taught by Prof.Harshith"
				+ System.getProperty("line.separator")
				+ "ii. Find the names of all classes that either meet in room R128 or have five or more Students enrolled."
				+ System.getProperty("line.separator")
				+ "iii. Find the names of all students who are enrolled in two classes that meet at the same time."
				+ System.getProperty("line.separator")
				+ "iv. Find the names of faculty members who teach in every room in which some class is taught."
				+ System.getProperty("line.separator")
				+ "v. Find the names of faculty members for whom the combined enrollment of the courses that they teach is less than five.";
		url = "http://vtulabs.comeze.com/DBMS_LAB/1.STUD";

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