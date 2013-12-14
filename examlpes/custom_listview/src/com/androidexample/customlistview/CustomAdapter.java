package com.androidexample.customlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class CustomAdapter extends BaseAdapter implements OnClickListener {

	/*********** Declare Used Variables *********/
	private Activity activity;
	private ArrayList<ListModel> category_data;
	private ArrayList<ListModel> courses_data;
	private static LayoutInflater inflater = null;
	public Resources res;
	ListModel tempValues = null;
	int i = 0;

	/************* CustomAdapter Constructor *****************/
	public CustomAdapter(Activity a, ArrayList<ListModel> categories,
			ArrayList<ListModel> courses, Resources resLocal) {

		/********** Take passed values **********/
		this.activity = a;
		this.category_data = categories;
		this.courses_data = courses;
		this.res = resLocal;

		/*********** Layout inflator to call external xml layout () **********************/
		this.inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	/******** What is the size of Passed Arraylist Size ************/
	public int getCount() {

		if (this.category_data.size() <= 0)
			return 1;
		return (this.category_data.size() + this.courses_data.size());
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	/********* Create a holder to contain inflated xml file elements ***********/
	public static class ViewHolder {

		public TextView text;
		public TextView text1;
		public TextView textWide;
		public ImageView image;

	}

	/*********** Depends upon data size called for each row , Create each ListView row ***********/
	public View getView(int position, View convertView, ViewGroup parent) {

		View vi = convertView;
		ViewHolder holder = null;

		/********** Inflate tabitem.xml file for each row ( Defined below ) ************/
		if(this.category_data.size() > position){
			vi = inflater.inflate(R.layout.category_items, null);
			/******** View Holder Object to contain tabitem.xml file elements ************/
			holder = new ViewHolder();
			holder.text = (TextView) vi.findViewById(R.id.text);
			holder.text1 = (TextView) vi.findViewById(R.id.text1);
			holder.image = (ImageView) vi.findViewById(R.id.image);

		
			tempValues = null;
			tempValues = (ListModel) category_data.get(position);

			/************ Set Model values in Holder elements ***********/
			holder.text.setText(tempValues.getCompanyName());
			holder.text1.setText(tempValues.getUrl());
			holder.image.setImageResource(res.getIdentifier(
					"com.androidexample.customlistview:drawable/"
							+ tempValues.getImage(), null, null));

			/******** Set Item Click Listner for LayoutInflater for each row ***********/
			vi.setOnClickListener(new OnItemClickListener(position));
		}
		else{
			vi = inflater.inflate(R.layout.course_items, null);
			holder.text = (TextView) vi.findViewById(R.id.course_id);

			tempValues = null;
			tempValues = (ListModel) courses_data.get(position);

			/************ Set Model values in Holder elements ***********/
			holder.text1.setText(tempValues.getUrl());

			/******** Set Item Click Listner for LayoutInflater for each row ***********/
			vi.setOnClickListener(new OnItemClickListener(position));
		}


		/************ Set holder with LayoutInflater ************/
		vi.setTag(holder);

		holder = (ViewHolder) vi.getTag();

//		if (convertView == null) {
//
//		} else
//

//		if (category_data.size() <= 0) {
//			holder.text.setText("No Data");
//
//		} else {
//			/***** Get each Model object from Arraylist ********/
//		}
		return vi;
	}

	@Override
	public void onClick(View v) {
		Log.v("CustomAdapter", "=====Row button clicked");
	}

	/********* Called when Item click in ListView ************/
	private class OnItemClickListener implements OnClickListener {
		private int mPosition;

		OnItemClickListener(int position) {
			mPosition = position;
		}

		@Override
		public void onClick(View arg0) {
			CustomListViewAndroidExample sct = (CustomListViewAndroidExample) activity;
			sct.onItemClick(mPosition);
		}
	}
}