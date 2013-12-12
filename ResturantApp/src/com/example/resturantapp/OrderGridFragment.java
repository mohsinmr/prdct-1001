package com.example.resturantapp;







import android.annotation.SuppressLint;
import android.content.res.TypedArray;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("ValidFragment")
public class OrderGridFragment extends Fragment{

	private int mPos = -1;
	private int mImgRes;
	public OrderGridFragment (){}
	
	public OrderGridFragment(int pos) {
		mPos = pos;
	}
	
	@SuppressLint("Recycle")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (mPos == -1 && savedInstanceState != null)
			mPos = savedInstanceState.getInt("mPos");
		
		TypedArray imgs = getResources().obtainTypedArray(R.array.course_img);
		mImgRes = imgs.getResourceId(mPos, -1);
		
		//mImgRes =  getResources().getDrawable(R.drawable.samosa);
		GridView gv = (GridView) inflater.inflate(R.layout.list_grid, null);
		gv.setBackgroundResource(android.R.color.white);
		gv.setAdapter(new GridAdapter());
		gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				if (getActivity() == null)
					return;
				Order_list activity = (Order_list) getActivity();
				activity.showMessage("Griid Pressed"+""+position);
			}			
		});
		return gv;
		
		//return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("mPos", mPos);
	}
	
	
	private class GridAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 30;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.table_row_item, null);
			}
			
			ImageView imageViewDish = (ImageView)convertView.findViewById(R.id.grid_item_img);
			TextView txtViewDishName = (TextView)convertView.findViewById(R.id.tvIitemName);
			TextView txtViewDishPrice = (TextView)convertView.findViewById(R.id.tvPriceTag);
			
			imageViewDish.setImageResource(mImgRes);
			txtViewDishName.setText("SAMOSA");
			txtViewDishPrice.setText("20.00");
			return convertView;
		}
		
	}
	
	
	
}
