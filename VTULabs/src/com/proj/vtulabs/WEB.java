package com.proj.vtulabs;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WEB extends ListActivity {

	String subs[] = { "WEB1", "WEB2", "WEB3", "WEB4", "WEB5", "WEB6", "WEB7",
			"WEB8", "WEB9", "WEB10", "WEB11" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(WEB.this,
				android.R.layout.simple_list_item_1, subs));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		String selectedsub = subs[position];
		super.onListItemClick(l, v, position, id);
		try {
			@SuppressWarnings("rawtypes")
			Class ourc = Class.forName("com.proj.vtulabs." + selectedsub);
			Intent i = new Intent(WEB.this, ourc);
			startActivity(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
