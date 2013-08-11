package com.proj.vtulabs;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class COMP_GRAP_CSE extends ListActivity {

	String subs1[] = { "COMP_GRAP1", "COMP_GRAP2", "COMP_GRAP3", "COMP_GRAP4",
			"COMP_GRAP5", "COMP_GRAP6", "COMP_GRAP7", "COMP_GRAP8",
			"COMP_GRAP9", "COMP_GRAP10", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(COMP_GRAP_CSE.this,
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
			Intent ourIntent = new Intent(COMP_GRAP_CSE.this, ourc);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
