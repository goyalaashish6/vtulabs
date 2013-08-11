package com.proj.vtulabs;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MP extends ListActivity {

	String subs[] = { "MP1a", "MP1b", "MP2a", "MP2b", "MP3a", "MP3b", "MP4a",
			"MP4b", "MP5a", "MP5b", "MP6a", "MP16b", "MP7a", "MP7b", "MP8a",
			"MP8b", "MP9a", "MP9b", "MP10a", "MP10b", "MP11a", "MP11b",
			"MP12a", "MP12b" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(MP.this,
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
			Intent i = new Intent(MP.this, ourc);
			startActivity(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
