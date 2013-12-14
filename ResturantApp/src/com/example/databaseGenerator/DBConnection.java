package com.example.databaseGenerator;

import com.example.resturantapp.MainActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBConnection {

	private static SQLiteDatabase database=null;
	

	public static String createConnection(){
		try{
		   database = DataBaseClass.getDatabase();
		   if(database==null)	
		   {
			DataBaseClass.openDatabase(MainActivity.context, Configuration.dataBaseName) ;
			database = DataBaseClass.getDatabase();
//			connected=true;
		   }
		}catch(Exception e)
		{
			return "Error:\n"+e.toString();
		}
		return "DONE";
	}

	
	public static boolean executeQuery(String query, String[] values){
		try{
			database.execSQL(query,values);
		}catch(Exception e){return false;}
		return true;
	}
	
	
	public static boolean executeQuery(String query)
	{
		try{
			database.execSQL(query);
		}catch(Exception e){return false;}
		return true;
	}
	
	public static Cursor rawQuery(String query, String[] where)
	{
		try{
			return  database.rawQuery(query,where);
		}catch(Exception e){return null;}
	}
	

	public static boolean insertSKURecord(String table, ContentValues values)
	{
		try{
			database.insertOrThrow(table,null, values);
		}catch(Exception e){
			e.printStackTrace();
			return false;}
		return true;
	}

	 

	public static boolean deleteSKURecord(String table, String where, String[] values)
	{
		try{
			// db.delete("tbl_states", "id=?", new String[] {Long.toString(countryId)});
			database.delete(table, where ,values);
		}catch(Exception e){return false;}
		return true;
	}

	

	public static boolean updateRecord(String query, ContentValues  upDateValues, String whereCols, String[] whereValues)
	{
		try{
			database.update(query, upDateValues , whereCols, whereValues);
		}catch(Exception e){return false;}
		return true;
	}
	
	

	public static String deleteTable(String table){
		try{
			database.delete(table, null, null);
		}catch(Exception e){return "Error:\n"+e.toString();}
		return "DONE";
	}


	
	public static boolean insertRecord(String table, ContentValues values) {		
		try {
			database.insertOrThrow(table, null, values);
		}
	
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean setBeginTransaction(boolean condition){
		boolean result=false;
		if(condition && (database!=null)){
	 	 database.beginTransaction();
	 	 result=true;
		}
		return result;
	}

	
	
	static public boolean committTransaction(){
		try
		{                         
			if(database!=null)
			{
				//this makes sure transaction is committed                         
				database.setTransactionSuccessful();
				database.endTransaction();                 
			}
		}
		catch(Exception e){return false;}
		return true;
	}	
	
	public static String closeConnection(){
		try{
		   if(database!=null){	
			   database.endTransaction();                 
			   database.close();
			   database=null;
			   DataBaseClass.closeDatabase();
		   }
		}catch(Exception e){return "Error:\n"+e.toString();}
		return "DONE";
	}
	
	public static boolean setQueryTransaction(boolean condition){
		if(condition)	
		database.setTransactionSuccessful();
		else
		database.endTransaction();                
		return condition;
	}	
	
	//creatinf for scheme merging so resolved this ....
	public static SQLiteDatabase getDatabasebj(){
		return database;
	}	
	
}
