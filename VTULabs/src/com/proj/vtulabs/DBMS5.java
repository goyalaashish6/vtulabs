package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DBMS5 extends Activity implements OnClickListener {

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
			Intent a1 = new Intent(DBMS5.this, Webv.class);
			a1.putExtras(b1);
			startActivity(a1);
			break;
		case R.id.progdown:
			Bundle b2 = new Bundle();
			b2.putString("key", url);
			Intent a2 = new Intent(DBMS5.this, AndroidFileDownloader.class);
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

		pn = "PROGRAM 5";
		pd = "Consider the following database for a banking enterprise:"
				+ System.getProperty("line.separator")
				+ "BRANCH(branch-name:string, branch-city:string, assets:real)"
				+ System.getProperty("line.separator")
				+ "ACCOUNT(accno:int, branch-name:string, balance:real)"
				+ System.getProperty("line.separator")
				+ "DEPOSITOR(customer-name:string, accno:int)"
				+ System.getProperty("line.separator")
				+ "CUSTOMER(customer-name:string, customer-street:string, customer-city:string)"
				+ System.getProperty("line.separator")
				+ "LOAN(loan-number:int, branch-name:string, amount:real)"
				+ System.getProperty("line.separator")
				+ "BORROWER(customer-name:string, loan-number:int)"
				+ System.getProperty("line.separator")
				+ "Write each of the following queries in SQL."
				+ System.getProperty("line.separator")
				+ "i. Create the above tables by properly specifying the primary keys and the foreign keys"
				+ System.getProperty("line.separator")
				+ "ii. Enter at least five tuples for each relation"
				+ System.getProperty("line.separator")
				+ "iii. Find all the customers who have at least two accounts at the Main branch."
				+ System.getProperty("line.separator")
				+ "iv. Find all the customers who have an account at all the branches located in a specific city."
				+ System.getProperty("line.separator")
				+ "v. Demonstrate how you delete all account tuples at every branch located in a specific city."
				+ System.getProperty("line.separator")
				+ "vi. Generate suitable reports."
				+ System.getProperty("line.separator")
				+ "vii. Create suitable front end for querying and displaying the results.";
		url = "http://vtulabs.comeze.com/DBMS_LAB/5.BANK";

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
