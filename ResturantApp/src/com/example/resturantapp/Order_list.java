package com.example.resturantapp;








import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.View;

import com.actionbarsherlock.internal.widget.ActionBarView.HomeView;
import com.actionbarsherlock.view.MenuItem;



import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



public class Order_list extends SlidingFragmentActivity{

	private Fragment mContent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setTitle(R.string.book_order);
	/*	setSlidingActionBarEnabled(true);

		setContentView(R.layout.order_frame);
		
		if(findViewById(R.id.menu_frame)==null)
		{
			setContentView(R.layout.menu_frame);
			getSlidingMenu().setSlidingEnabled(true);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
			// show home as up so we can toggle
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		} else {
			// add a dummy view
			View v = new View(this);
			setBehindContentView(v);
			getSlidingMenu().setSlidingEnabled(false);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
 */
		if (savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
		if (mContent == null)
			mContent = new ColorFragment(R.color.red);	
		
		setContentView(R.layout.order_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.order_frame, mContent)
		.commit();

		// set the Behind View Fragment
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new ColorMenuFragment())
		.commit();

		
		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT_RIGHT);
		sm.setTouchModeAbove(SlidingMenu.LEFT_RIGHT);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindScrollScale(0.25f);
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
	
	public void switchContent(Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.order_frame, fragment)
		.commit();
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
	
	
	
}
