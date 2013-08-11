package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WEB4 extends Activity implements OnClickListener {

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
			Intent a2 = new Intent(WEB4.this, AndroidFileDownloader.class);
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

		pn = "PROGRAM 4";
		pd = "a) Design an XML document to store information about a student in an engineering college affiliated to VTU. The information must include USN, Name, Name of the College, Brach, Year of Joining, and e-mail id. Make up sample data for 3 students. Create a CSS style sheet and use it to display the document."
				+ System.getProperty("line.separator")
				+ "b) Create an XSLT style sheet for one student element of the above document and use it to create a display of that element.";
		url = "http://vtulabs.comeze.com/WP_LAB/4.Prog4.zip";

		down = (Button) findViewById(R.id.progdown);
		name = (TextView) findViewById(R.id.progname);
		desc = (TextView) findViewById(R.id.progdesc);
		down.setOnClickListener(this);
		name.setText(pn);
		desc.setText(pd);
	}

}
