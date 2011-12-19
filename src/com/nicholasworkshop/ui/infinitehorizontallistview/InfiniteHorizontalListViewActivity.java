package com.nicholasworkshop.ui.infinitehorizontallistview;

import java.util.LinkedList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class InfiniteHorizontalListViewActivity extends Activity {
	/** Called when the activity is first created. */
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);
		InfiniteHorizontalListView listview = (InfiniteHorizontalListView) findViewById(R.id.infiniteHorizontalListView1);
		listview.setAdapter(mAdapter);
		
		for (int i = 0; i < 3; i++) {
			data.add("   Bonjour" + i);
		}
		listview.setSelection(Integer.MAX_VALUE/2);
	}
	
	private LinkedList<String> data = new LinkedList<String>();

	private BaseAdapter mAdapter = new BaseAdapter() {

		@Override public int getCount() {
			//return Integer.MAX_VALUE;
			return data.size();
		}

		@Override public Object getItem(int position) {
			return null;
		}

		@Override public long getItemId(int position) {
			return 0;
		}

		@Override public View getView(int position, View convertView, ViewGroup parent) {
			//View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem, null);
			TextView tv = new TextView(getApplicationContext());
			tv.setTextSize(20);
			tv.setText(data.get(Math.abs(position) % data.size()));

			return tv;
		}

	};
}