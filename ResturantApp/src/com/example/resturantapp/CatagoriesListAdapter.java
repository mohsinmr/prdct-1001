package com.example.resturantapp;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CatagoriesListAdapter extends ListFragment{
	
	String MenuName ="";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.table_list, null);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] catagoriesArray =getResources().getStringArray(R.array.CATAGORIES_ARRAY);
		ArrayAdapter<String> catagoriesAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, catagoriesArray);
		setListAdapter(catagoriesAdapter);
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	
		super.onListItemClick(l, v, position, id);
		MenuName = l.getItemAtPosition(position).toString();
		System.out.println(MenuName);
		Fragment mContent =new OrderGridFragment(position);
		if(mContent!=null){
			switchFragment(mContent);
		}
	}
	private void switchFragment(Fragment fragment){
		if(getActivity()==null)
		return ;
		else
			if(getActivity() instanceof Order_list){
				Order_list objOrderList = (Order_list)getActivity();
				System.out.println(MenuName);
				objOrderList.switchContent(fragment);
		}
	}
}
