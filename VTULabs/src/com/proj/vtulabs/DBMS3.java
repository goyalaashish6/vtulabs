package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DBMS3 extends Activity implements OnClickListener {

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
			Intent a1 = new Intent(DBMS3.this, Webv.class);
			a1.putExtras(b1);
			startActivity(a1);
			break;
		case R.id.progdown:
			Bundle b2 = new Bundle();
			b2.putString("key", url);
			Intent a2 = new Intent(DBMS3.this, AndroidFileDownloader.class);
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

		pn = "PROGRAM 3";
		pd = "Consider the following database of student enrollment in courses & books adopted for each course:"
				+ System.getProperty("line.separator")
				+ "STUDENT (regno: string, name: string, major: string, bdate:date)"
				+ System.getProperty("line.separator")
				+ "COURSE (course #:int, cname:string, dept:string)"
				+ System.getProperty("line.separator")
				+ "ENROLL ( regno:string, course#:int, sem:int, marks:int)"
				+ System.getProperty("line.separator")
				+ "BOOK _ ADOPTION (course# :int, sem:int, book-ISBN:int)"
				+ System.getProperty("line.separator")
				+ "TEXT (book-ISBN:int, book-title:string, publisher:string, author:string)"
				+ System.getProperty("line.separator")
				+ "Write each of the following queries in SQL."
				+ System.getProperty("line.separator")
				+ "i. Create the above tables by properly specifying the primary keys and the foreign keys."
				+ System.getProperty("line.separator")
				+ "ii. Enter at least five tuples for each relation."
				+ System.getProperty("line.separator")
				+ "iii. Demonstrate how you add a new text book to the database and make this book be adopted by some department."
				+ System.getProperty("line.separator")
				+ "iv. Produce a list of text books (include Course #, Book-ISBN, Book-title) in the alphabetical order for courses offered by the ‘CS’ department that use more than two books."
				+ System.getProperty("line.separator")
				+ "v. List any department that has all its adopted books published by a specific publisher."
				+ System.getProperty("line.separator")
				+ "vi. Generate suitable reports."
				+ System.getProperty("line.separator")
				+ "vii. Create suitable front end for querying and displaying the results.";
		url = "http://vtulabs.comeze.com/DBMS_LAB/3.BOOK";

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
