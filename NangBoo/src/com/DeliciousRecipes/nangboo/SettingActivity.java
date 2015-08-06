package com.DeliciousRecipes.nangboo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/* 軒什闘坂税 緩そそそそそそそ*/


public class SettingActivity extends ListActivity implements OnItemClickListener {

//	ListView mListView = null;
//	BaseAdapter_setting mAdapter = null;

	final String[] items = new String[]{"硝顕", "砺原", "越切 滴奄", "獄穿 貢 鯵降遭 舛左"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_setting);

//		setListAdapter((ListAdapter) new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items));
		
		ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		
		ListView list = (ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(this);
		
	}
	
	
	
//	@Override
//	protected void onListItemClick(ListView l, View v, int position, long id) {
//		// TODO Auto-generated method stub
//		super.onListItemClick(l, v, position, id);
//	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(this, items[position]+" is clicked.", Toast.LENGTH_LONG).show();
			
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
