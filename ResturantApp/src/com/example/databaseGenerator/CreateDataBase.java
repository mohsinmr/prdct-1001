package com.example.databaseGenerator;

import java.io.FileOutputStream;
import java.io.InputStream;

import com.example.resturantapp.MainActivity;

import android.content.Context;
import android.content.res.AssetManager;

public class CreateDataBase {

	MainActivity context=null;
	public CreateDataBase(MainActivity context){
		this.context=context;
	}
	
	public String createDB(MainActivity context)
	{
		String insertMsg="";
   	 	try
   	 	{	
   		 	boolean Error = DataBaseClass.openDatabase(context,Configuration.dataBaseName);
   		 	//if(Error){
   		 	if(!((SSCApplication)context.getApplicationContext()).getDBCreated()){
   		 	insertMsg = (" Database Exists... ");
   		 	return insertMsg; 
   		 	}
   		 	
         	String data="";
         	AssetManager am = context.getAssets();
         	InputStream in = am.open("dbase");
         	byte dbDataBase[] = new byte[in.available()];
         	in.read(dbDataBase,0,dbDataBase.length);
         	data = new String(dbDataBase);
         	System.out.println("Database SQL-->"+dbDataBase);
         	String line = "";
         	((SSCApplication)context.getApplicationContext()).setDBCreated(false);
         	

         	//***** WRITE IN FILE *******//
         	try {
         		  // open Query.txt for writing
         	      FileOutputStream out = this.context.openFileOutput("Query.txt", Context.MODE_WORLD_WRITEABLE);
         		  // write the contents on mySettings to the file
         		  out.write(("//********************** PARSED BY BHATTI **********************//\n"+data+"//********************** PARSED COMPLETED **********************//\n").getBytes());
         		  // close the file
         		  out.close();
         		 //insertMsg= (" Write query in file  successfully...\nFile Size : "+dbDataBase.length);
         		} catch (Exception e) {
         			e.printStackTrace();
         			insertMsg= (" Error in Writing query in file...\n"+e.toString());
         			return insertMsg;
         		}         	
           	//***** END WRITE IN FILE *******//
         		

         		
         		
         	//***** DELETE ALL TABLES IF EXIST *******//
         	line = DataBaseClass.deleteAllTables(data);
         	if(!line.trim().equals("DONE"))
         	insertMsg= ("Table Error :\n "+insertMsg);
         	//***** END - DELETE ALL TABLES IF EXIST *******//
         	
         	

         	
         	
         	
         	//******* CREATE ALL TABLES IN DATABASE *******//
         	line = DataBaseClass.createAllTables(data.trim());
           	if(!line.trim().equals("DONE"))
           	insertMsg= (" Error in table creating..."+line);           		
           	//******* END CREATE ALL TABLES IN DATABASE *******//

                	
           	
           	boolean bln = DataBaseClass.beginTransaction();
           	if(bln)
           	insertMsg= (" Error in transaction begining...");           		
           	// END TRANSACTION IN DATABASE //
           	
           	
           	// DATA INSERTION IN DATABASE TABLES //
           	//data="GO\nINSERT INTO [AVA_VIS_DETAIL] ([DOC_NO],[DOC_DATE],[SKU],[AVAILABILITY],[VISIBILITY],[AVAILABLE_CODE],[VISIBLE_CODE],[SKU_INDEX]) VALUES ('1','2010-07-17 00:00:00.000','0081487',12,6,'0001','',1);\n";
         	line = DataBaseClass.insertDataTables(data.trim());
           	if(!line.trim().equals("DONE"))
           	insertMsg= (" Error :\n"+line);           		
           	// END CREATE ALL TABLES IN DATABASE //

         	// COMMIT TRANSACTION IN DATABASE //
            bln = DataBaseClass.committQuery();
            if(bln)
            insertMsg= (" Error in query committ...");	
           	// END COMMIT TRANSACTION IN DATABASE //           	
            Error = DataBaseClass.closeDatabase();
            if(Error)
            insertMsg= (" Database Can Not Closed... ");

         }catch(Exception e){
        	 e.printStackTrace();
         	insertMsg=(" Reading Error! ");
         }
		return insertMsg;
	}
	
}
