package com.example.resturantapp;

import java.util.ArrayList;

import com.example.resturantapp.SampleListFragment.SampleAdapter;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;



public class OrderGridList extends ListFragment{

	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
		
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		ArrayList<String> items = new ArrayList<String>();
		items.add(0, "Enter Name");
		items.add(1, "Enter FirstName");
		items.add(2, "Enter LastName");
		items.add(3, "Enter EmailID");
		items.add(4, "Enter TelephoneNo");
		items.add(5, "Enter POSTALCODE");
		items.add(6, "Enter Town");
		items.add(7, "Enter City");
		items.add(8, "Enter AreaCode");
		items.add(9, "Enter Address1");
		items.add(10, "Enter Address1");
		items.add(11, "Enter StreetNo");
		items.add(12, "Enter DOB");
		items.add(13, "Enter userID");
		items.add(14, "Enter Password");
		items.add(15, "Enter EmailID");
		items.add(16, "Enter TelephoneNo");
		items.add(17, "Enter EmailID");
		items.add(18, "Enter TelephoneNo");	items.add(3, "Enter EmailID");
		items.add(19, "Enter TelephoneNo");
		items.add(20, "Enter EmailID");
		items.add(21, "Enter TelephoneNo");
		

		//for (int i = 0; i < 20; i++) {
			
			for (int j = 0; j < items.size(); j++) {
				
				adapter.add(new SampleItem(""+items.get(j).toString()));
				//adapter.add(new SampleItem(""+items.get(j).toString(), android.R.drawable.ic_menu_search));
				
			}
	//}
		setListAdapter(adapter);
	}

	private class SampleItem {
		public String tag;
		//public int iconRes;
		//public SampleItem(String tag, int iconRes) {
			public SampleItem(String tag) {
			this.tag = tag; 
		//	this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.table_list, null);
			}
		return convertView;
		}

	}
	
}
