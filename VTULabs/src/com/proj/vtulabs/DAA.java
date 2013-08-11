package com.proj.vtulabs;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DAA extends ListActivity {

	String subs1[] = { "DAA1", "DAA2", "DAA3", "DAA4", "DAA5", "DAA6", "DAA7a",
			"DAA7b", "DAA8", "DAA9", "DAA10", "DAA11", "DAA12" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(DAA.this,
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
			Intent ourIntent = new Intent(DAA.this, ourc);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
