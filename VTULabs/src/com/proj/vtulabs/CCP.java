package com.proj.vtulabs;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CCP extends ListActivity {

	String subs1[] = { "CCP1", "CCP2", "CCP3", "CCP4", "CCP5", "CCP6", "CCP7",
			"CCP8", "CCP9", "CCP10", "CCP11", "CCP12", "CCP13", "CCP14",
			"CCP15", "CCP16" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(CCP.this,
				android.R.layout.simple_list_item_1, subs1));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		String selectedsub = subs1[position];
		super.onListItemClick(l, v, position, id);
		try {
			@SuppressWarnings({ "rawtypes" })
			Class ourc = Class.forName("com.proj.vtulabs." + selectedsub);
			Intent ourIntent = new Intent(CCP.this, ourc);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
