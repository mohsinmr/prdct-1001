package com.example.resturantapp;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;






public class MainActivity extends BaseActivity  {


	
	public MainActivity() {
		super(R.string.app_name);
		// 
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setSlidingActionBarEnabled(true);
		setContentView(R.layout.activity_main);
		Button btnLogin = (Button)findViewById(R.id.button1);
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(MainActivity.this, "Next Screen is under Construction", Toast.LENGTH_LONG).show();
				
			}
		});
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		return super.onCreateOptionsMenu(menu);
	}



	

}
