package uz.main.hashchat;



import android.annotation.TargetApi;
import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ContactManager extends Activity {

	public static final String TAG = "ContactManager";

    private Button mAddAccountButton;
    private ListView mContactList;
    private boolean mShowInvisible;
    private CheckBox mShowInvisibleControl;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_manager);
		// Show the Up button in the action bar.
		setupActionBar();
		
		mAddAccountButton = (Button) findViewById(R.id.addContactButton);
        mContactList = (ListView) findViewById(R.id.listContact);
        mShowInvisibleControl = (CheckBox) findViewById(R.id.showInvisible);
        
        mShowInvisible = false;
        mShowInvisibleControl.setChecked(mShowInvisible);
        
        mAddAccountButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "mAddAccountButton clicked");
               // launchContactAdder();
            }
        });
        mShowInvisibleControl.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "mShowInvisibleControl changed: " + isChecked);
                mShowInvisible = isChecked;
                populateContactList();
            }
        });
			
        populateContactList();	
		
        
	}
	 @SuppressWarnings("deprecation")
	 private void populateContactList() {
	        // Build adapter with contact entries
	        Cursor cursor = getContacts();
	        String[] fields = new String[] {
	        		
	                ContactsContract.Data.DISPLAY_NAME
	        };
	        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.contact_entry,cursor,fields,new int[] {R.id.contactEntryText});
	        mContactList.setAdapter(adapter);
	    }
	
	 @SuppressWarnings("deprecation")
	private Cursor getContacts()
	    {
	        // Run query
	        Uri uri = ContactsContract.Contacts.CONTENT_URI;
	        String[] projection = new String[] {
	                ContactsContract.Contacts._ID,
	                ContactsContract.Contacts.DISPLAY_NAME
	        };
	        String selection = ContactsContract.Contacts.IN_VISIBLE_GROUP + " = '" +
	                (mShowInvisible ? "0" : "1") + "'";
	        String[] selectionArgs = null;
	        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC";

	        return managedQuery(uri, projection, selection, selectionArgs, sortOrder);
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
		getMenuInflater().inflate(R.menu.contact_manager, menu);
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
