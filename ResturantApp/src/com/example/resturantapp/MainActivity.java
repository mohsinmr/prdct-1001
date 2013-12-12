package com.example.resturantapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;




import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;







public class MainActivity extends BaseActivity  {


	
	public MainActivity() {
		super(R.string.app_name);
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
				//Toast.makeText(MainActivity.this, "Next Screen is under Construction", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(MainActivity.this,Order_list.class);
				startActivity(intent);
			}
		});
		
	}

	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			SlidingMenu sm = getSlidingMenu();
			sm.setMode(SlidingMenu.LEFT_RIGHT);
			sm.setSecondaryMenu(getLayoutInflater().inflate(R.layout.menu_frame_two, null));
			getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.menu_frame_two, new SampleListFragment())
			.commit();					
			sm.setSecondaryShadowDrawable(R.drawable.shadowright);
			sm.setShadowDrawable(R.drawable.shadow);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}*/



	

}
