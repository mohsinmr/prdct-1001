package uz.main.hashchat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class Views extends Activity {

	Model model;
	GridView gridView;

	public Views() {
		model = new Model();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_views);
		// Show the Up button in the action bar.
		//setupActionBar();
		model.LoadMenuGridModel();
		gridView = (GridView)findViewById(R.id.menuGrid);
		MenuGridAdapter adapter = new MenuGridAdapter(getApplicationContext(),model);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
			//	Toast.makeText(getApplicationContext(),"position : " + position , Toast.LENGTH_SHORT).show();
				if(model.GetbyId(position).getName().equals("Search"))
				{
				Intent intent =new Intent(getApplicationContext(), ContactManager.class);
				intent.putExtra(DISPLAY_SERVICE, "position : " + position + ". Tapped :" + model.GetbyId(position).getName());
				startActivity(intent);
				}
				else
				{
					Intent intent =new Intent(getApplicationContext(), CList.class);
					intent.putExtra(DISPLAY_SERVICE, "position : " + position + ". Tapped :" + model.GetbyId(position).getName());
					startActivity(intent);
				}
				
			}
			
		});
			
		
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.views, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
