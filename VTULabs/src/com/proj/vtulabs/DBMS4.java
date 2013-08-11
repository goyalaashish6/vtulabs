package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DBMS4 extends Activity implements OnClickListener {

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
			Intent a1 = new Intent(DBMS4.this, Webv.class);
			a1.putExtras(b1);
			startActivity(a1);
			break;
		case R.id.progdown:
			Bundle b2 = new Bundle();
			b2.putString("key", url);
			Intent a2 = new Intent(DBMS4.this, AndroidFileDownloader.class);
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

		pn = "PROGRAM 4";
		pd = "The following tables are maintained by a book dealer:"
				+ System.getProperty("line.separator")
				+ "AUTHOR (author-id:int, name:string, city:string, country:string)"
				+ System.getProperty("line.separator")
				+ "PUBLISHER (publisher-id:int, name:string, city:string, country:string)"
				+ System.getProperty("line.separator")
				+ "CATALOG (book-id:int, title:string, author-id:int, publisher-id:int, category-id:int, year:int, price:int)"
				+ System.getProperty("line.separator")
				+ "CATEGORY (category-id:int, description:string)"
				+ System.getProperty("line.separator")
				+ "ORDER-DETAILS (order-no:int, book-id:int, quantity:int)"
				+ System.getProperty("line.separator")
				+ "Write each of the following queries in SQL."
				+ System.getProperty("line.separator")
				+ "i. Create the above tables by properly specifying the primary keys and the foreign keys."
				+ System.getProperty("line.separator")
				+ "ii. Enter at least five tuples for each relation."
				+ System.getProperty("line.separator")
				+ "iii. Give the details of the authors who have 2 or more books in the catalog and the price of the books is greater than the average price of the books in the catalog and the year of publication is after 2000."
				+ System.getProperty("line.separator")
				+ "iv. Find the author of the book which has maximum sales."
				+ System.getProperty("line.separator")
				+ "v. Demonstrate how you increase the price of books published by a specific publisher by 10%."
				+ System.getProperty("line.separator")
				+ "vi. Generate suitable reports."
				+ System.getProperty("line.separator")
				+ "vii. Create suitable front end for querying and displaying the results.";
		url = "http://vtulabs.comeze.com/DBMS_LAB/4.CATALOG";

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
