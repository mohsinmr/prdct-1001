package com.example.resturantapp;








import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.actionbarsherlock.view.MenuItem;




import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



public class Order_list extends SlidingFragmentActivity{

	private Fragment mContent;
	ArrayList<String> coursesArray;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		
		setTitle(R.string.book_order);

		if (savedInstanceState != null) 
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
		if (mContent == null)
			mContent = new OrderGridFragment(0);	
		
		setContentView(R.layout.order_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.order_frame, mContent)
		.commit();

		// set the Behind View Fragment
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new CatagoriesListAdapter())
		.commit();

		
		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT_RIGHT);
		sm.setTouchModeAbove(SlidingMenu.LEFT_RIGHT);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindScrollScale(0.25f);
		sm.setBehindWidth(333);
		sm.setFadeDegree(0.25f);
		sm.setSecondaryMenu(getLayoutInflater().inflate(R.layout.menu_frame_two, null));
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame_two, new SampleListFragment())
		.commit();					
		sm.setSecondaryShadowDrawable(R.drawable.shadowright);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}
	
	public void switchContent(final Fragment fragment) {
		mContent = fragment;
		String mMenuName  =mContent.toString(); 
		System.out.println(mMenuName);
		
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.order_frame, fragment)
		.commit();
		Handler h = new Handler();
		h.postDelayed(new Runnable() {
			public void run() {
				getSlidingMenu().showContent();
			}
		}, 50);
		getSlidingMenu().showContent();
	}	

  /*  @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
*/
  /*  @Override
    public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            if (enableHomeIconActionSlidingMenu()
                    && menu != null) {
                menu.toggle();
            } else if (enableHomeIconActionBack()) {
                onCustomBackPressed();
            }
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }   

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_BACK:
            onCustomBackPressed();
            return true;
        default:
            return super.onKeyDown(keyCode, event);
        }
    }

    // If sliding menu is showing, we need to hide it on the first back button
    // press.
    private void onCustomBackPressed() {
        if (menu != null
                && menu.isMenuShowing()) {
            menu.toggle();
        } else {
            this.onBackPressed();
        }
    }

    *//**
     * Sets activity home icon to have up icon and on press act as device back
     * button press.
     * 
     * @return Activation state.
     *//*
    public boolean enableHomeIconActionBack() {
        return true;
    }

    *//**
     * Sets activity home icon to be as a sliding menu invoke icon and on press
     * call toggle command for the sliding menu.
     * 
     * @return Activation state.
     *//*
    public boolean enableHomeIconActionSlidingMenu() {
        return true;
    }*/
	
	
	
	void showMessage(String text)
	{
		Toast.makeText(Order_list.this, ""+text, Toast.LENGTH_LONG).show();
	}
	
}
