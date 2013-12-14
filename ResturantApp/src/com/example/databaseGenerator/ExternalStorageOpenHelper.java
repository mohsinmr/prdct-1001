package com.example.databaseGenerator;

import java.io.File;

import com.example.resturantapp.MainActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Environment;
import android.util.AndroidRuntimeException;

public class ExternalStorageOpenHelper {
	private SQLiteDatabase database = null;
	private File dbFile;
	private SQLiteDatabase.CursorFactory factory;
	public static String DB_PATH = "/data/data/com.example.resturantapp/databases/";
	public static String DB_NAME = Configuration.dataBaseName;
	public String myPath = DB_PATH + DB_NAME;
	public boolean typeOfDevice;
	public File appDbDir;

	public ExternalStorageOpenHelper(Context ctx, String dbFileName,
			SQLiteDatabase.CursorFactory factory) {
		try
		{
		this.factory = factory;

		appDbDir = new File(Environment.getExternalStorageDirectory(),
				"sndmobile/Database/");

		// MOUNTED CASE....

		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) || Environment.getExternalStorageState().equals(Environment.MEDIA_SHARED)) {

			// NOTE TRUE IF IT IS RUN ON EMULATOR OR MOBILE.....

			typeOfDevice = Build.MANUFACTURER.equals("unknown");

			// FALSE FOR DEVICE..

/*			if (!typeOfDevice) {
				if (!appDbDir.exists()) {
					appDbDir.mkdirs();
				}
				this.dbFile = new File(appDbDir, dbFileName);

			}
*/
			
			if (!typeOfDevice) {
				if (!appDbDir.exists()) {
					appDbDir.mkdirs();
				}
				this.dbFile = new File(appDbDir, dbFileName);
				if(!dbFile.exists())
				{
					dbFileName = Configuration.dataBaseName;
					this.dbFile = new File(appDbDir, dbFileName);
					dbFile.createNewFile();
					((SSCApplication)ctx.getApplicationContext()).setDBCreated(true);
				}
			}
			else
			{
				this.dbFile = new File(myPath);
				if(!dbFile.exists())
				{
					dbFileName = Configuration.dataBaseName;
					this.dbFile = new File(myPath);
					dbFile.createNewFile();
					//((SSCApplication)ctx.getApplicationContext()).setDBCreated(true);
						((SSCApplication)ctx.getApplicationContext()).setDBCreated(true);
				
				}
			}


		}
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED) && !Environment.getExternalStorageState().equals(Environment.MEDIA_SHARED)) {
			throw new AndroidRuntimeException(
					"External storage (SD-Card) not mounted");
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			//throw ex;
		}
	}

	public boolean databaseFileExists() {
		return dbFile.exists();
	}

	private void open() {
		
		if (dbFile.exists()) {
			database = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(),
					factory, SQLiteDatabase.OPEN_READWRITE);
			DataBaseClass.statusOfDB = true;
		}

	}

	public synchronized void close() {
		if (database != null) {
			database.close();
			database = null;
		}
	}

	public synchronized SQLiteDatabase getReadableDatabase() {
		return getDatabase();
	}

	public synchronized SQLiteDatabase getWriteableDatabase() {
		return getDatabase();
	}

	private SQLiteDatabase getDatabase() {
		if (!typeOfDevice) {
			open();
		}
		if(typeOfDevice)
		{
			if (database == null) {
				boolean res = checkDataBase();
				if (!res) {
					database = MainActivity.context.openOrCreateDatabase(myPath,SQLiteDatabase.OPEN_READWRITE, null);
					DataBaseClass.statusOfDB = false;
				}
				
				if(res)
				{
					database = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
					DataBaseClass.statusOfDB = true;					
				}
				System.out.println("Database couldn not be opend");
			}
		}
		return database;
	}

	private boolean checkDataBase() {

		SQLiteDatabase checkDB = null;

		try {
			
			checkDB = SQLiteDatabase.openDatabase(myPath, null,SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {

			// database does't exist yet.

		}

		if (checkDB != null) {

			checkDB.close();

		}

		return checkDB != null ? true : false;
	}
}
