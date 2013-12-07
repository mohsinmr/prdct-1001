package uz.main.hashchat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppSharedPreferences {
	public static final String KEY_PREFS_USERNAME = "username";
	public static final String KEY_PREFS_PASSWORD = "password";
	private static final String APP_SHARED_PREFS = AppSharedPreferences.class
			.getSimpleName(); 

	private SharedPreferences _sharedPrefs;
	private Editor _prefsEditor;

	public AppSharedPreferences(Context context) {
		this._sharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS,
				Activity.MODE_PRIVATE);
		this._prefsEditor = _sharedPrefs.edit();
	}

	public String getUsername() {
		return _sharedPrefs.getString(KEY_PREFS_USERNAME, "");
	}

	public void saveUsername(String text) {
		_prefsEditor.putString(KEY_PREFS_USERNAME, text);
		_prefsEditor.commit();
	}

	public String getPassword() {
		return _sharedPrefs.getString(AppSharedPreferences.KEY_PREFS_PASSWORD,
				"");
	}

	public void savePassword(String text) {
		_prefsEditor.putString(KEY_PREFS_PASSWORD, text);
		_prefsEditor.commit();
	}

}
