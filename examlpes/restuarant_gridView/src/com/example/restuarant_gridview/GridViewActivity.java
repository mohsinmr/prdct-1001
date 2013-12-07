package com.example.restuarant_gridview;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.GridView;

public class GridViewActivity extends Activity {

	private GridviewAdapter gAdapter;
	private ArrayList<String> listMenu;
	private ArrayList<Integer> listImages;

	private GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_view);

		prepareList();

		gAdapter = new GridviewAdapter(this, listMenu, listImages);

		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(gAdapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long length) {
				// TODO Auto-generated method stub
//				Toast.makeText(GridViewActivity.this, "" + gAdapter.getItem(position), Toast.LENGTH_SHORT);	
				final Dialog dialog = new Dialog(GridViewActivity.this);
				dialog.setContentView(R.layout.custom);
//				dialog.setTitle(gAdapter.getItemViewType(position));
				dialog.setTitle("Title");
				
				//set dialog text, image, etc
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText("" +gAdapter.getItem(position));
				ImageView image = (ImageView) dialog.findViewById(R.id.image);
				image.setImageResource(R.drawable.samosa);
				
				Button btnAdd = (Button) dialog.findViewById(R.id.addToCart);
//				btnAdd.setOnClickListener(new OnClickListener() {
//					
//					@Override
//					public void onClick(View v) {
//						// TODO Auto-generated method stub
//						dialog.dismiss();
//					}
//				});
				dialog.show();
			}	
			
		});
	}

	private void prepareList() {
		// TODO Auto-generated method stub
		listMenu = new ArrayList<String>();
		
		listMenu.add("Samosa");
		listMenu.add("Fries");
		listMenu.add("Zinger Burger");
		
		listImages = new ArrayList<Integer>();
		
		listImages.add(R.drawable.samosa);
		listImages.add(R.drawable.fries);
		listImages.add(R.drawable.zinger_burger);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_view, menu);
		return true;
	}

}
