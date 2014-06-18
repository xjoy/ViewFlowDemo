package com.pdh.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PullToRefreshListAdapter extends BaseAdapter {
	private String[] contentStr = { "ListView1", "ListView2", "ListView3",
			"ListView4", "ListView5", "ListView6", "ListView7", "ListView8",
			"ListView9", "ListView10", "ListView11", "ListView12", };
	private Context context;

	public PullToRefreshListAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return contentStr.length;
	}

	@Override
	public Object getItem(int position) {
		return contentStr[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		TextView contentTv;
		if (convertView != null) {
			contentTv = (TextView) convertView;
		} else {
			contentTv = new TextView(context);
		}
		contentTv.setHeight(25);
		contentTv.setText(contentStr[position]);
		return contentTv;
	}
}
