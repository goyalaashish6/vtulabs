package com.proj.vtulabs;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SS_OS extends ListActivity {

	String subs[] = { "SS_OS1a", "SS_OS1b", "SS_OS2a", "SS_OS2b", "SS_OS3",
			"SS_OS4a", "SS_OS4b", "SS_OS5a", "SS_OS5b", "SS_OS6", "SS_OS7a",
			"SS_OS7b", "SS_OS8a", "SS_OS8b", "SS_OS9a", "SS_OS9b", "SS_OS10",
			"SS_OS11", "SS_OS12" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(SS_OS.this,
				android.R.layout.simple_list_item_1, subs));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		String selectedSub = subs[position];
		super.onListItemClick(l, v, position, id);
		try {
			@SuppressWarnings("rawtypes")
			Class ourc = Class.forName("com.proj.vtulabs." + selectedSub);
			Intent i = new Intent(SS_OS.this, ourc);
			startActivity(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
