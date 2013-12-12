package com.example.resturantapp;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;


public class SampleListFragment extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
		
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		ArrayList<String> items = new ArrayList<String>();
		items.add(0, "FULL NAME");
		items.add(1, "USER NAME");
		items.add(2, "CELL no.(Password)");
		items.add(3, "EMAIL ADDRESS");
	
		

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
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
/*			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
*/
			EditText title = (EditText) convertView.findViewById(R.id.editTexLogin);
			title.setHint(getItem(position).tag);
			return convertView;
		}

	}
}
