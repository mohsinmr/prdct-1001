package com.example.resturantapp;





import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;




public class OrderMenuScreen extends android.support.v4.app.ListFragment{


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// 
		super.onActivityCreated(savedInstanceState);
		String[] LeftSlideOption = {"FIRST COURSE","SECOND COURSE","THIRD COURSE","MAIN COURSE","CATEGORIES","STARTER","DESERT"};
		ArrayAdapter<String> ordermenuAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, LeftSlideOption);
		setListAdapter(ordermenuAdapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
		
			newContent = new ColorFragment(R.color.red);
			break;
		case 1:
			newContent = new ColorFragment(R.color.green);
			break;
		case 2:
			newContent = new ColorFragment(R.color.blue);
			break;
		case 3:
			newContent = new ColorFragment(android.R.color.white);
			break;
		case 4:
			newContent = new ColorFragment(android.R.color.black);
			break;
		}
		if (newContent != null)
			switchFragment(newContent);
	}
	
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof Order_list) {
			Order_list fca = (Order_list) getActivity();
			fca.switchContent(fragment);
		} 
	}

	
	
	
}
