package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WEB8 extends Activity implements OnClickListener {

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
			Intent a2 = new Intent(WEB8.this, AndroidFileDownloader.class);
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

		pn = "PROGRAM 8";
		pd = "Write a Perl program to insert name and age information entered by the user into a table created using MySQL and to display the current contents of this table.";
		url = "http://vtulabs.comeze.com/WP_LAB/8.Prog8.zip";

		down = (Button) findViewById(R.id.progdown);

		name = (TextView) findViewById(R.id.progname);
		desc = (TextView) findViewById(R.id.progdesc);
		down.setOnClickListener(this);
		name.setText(pn);
		desc.setText(pd);
	}

}
