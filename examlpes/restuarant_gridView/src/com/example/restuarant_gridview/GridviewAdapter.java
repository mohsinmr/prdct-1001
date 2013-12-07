package com.example.restuarant_gridview;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridviewAdapter extends BaseAdapter {

	private ArrayList<String> listMenu;
	private ArrayList<Integer> listImages;
	private Activity activity;
	
	public GridviewAdapter(Activity activity, ArrayList<String> listMenu,ArrayList<Integer> listImages){
		super();
		this.listMenu = listMenu;
		this.listImages = listImages;
		this.activity = activity;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listMenu.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listMenu.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class ViewHolder{
		public ImageView imgViewMenu;
		public TextView txtViewTitle;
	}
	@Override
	public View getView(int postion, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder view;
		LayoutInflater inflater = activity.getLayoutInflater();
		
		if(convertView == null){
			view = new ViewHolder();
			convertView = inflater.inflate(R.layout.gridview_row, null);
			
			view.txtViewTitle = (TextView) convertView.findViewById(R.id.textView1);
			view.imgViewMenu = (ImageView) convertView.findViewById(R.id.imageView1);
			
			convertView.setTag(view);
		}
		else{
			view = (ViewHolder) convertView.getTag();
		}
		
		view.txtViewTitle.setText(listMenu.get(postion));
		view.imgViewMenu.setImageResource(listImages.get(postion));
		
		return convertView;
	}

}
