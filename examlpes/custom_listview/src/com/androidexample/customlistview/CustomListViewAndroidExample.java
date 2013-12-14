package com.androidexample.customlistview;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.res.Resources;


public class CustomListViewAndroidExample extends Activity {

	ListView list;
	CustomAdapter adapter;
	public  ArrayList<ListModel> CategoryItemsArray = new ArrayList<ListModel>();
	public  ArrayList<ListModel> CoursesItemsArray = new ArrayList<ListModel>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_list_view_android_example);
		
		
		/******** Take some data in Arraylist ( CategoryItemsArray ) ***********/
		setCategoryData();
		setCoursesData();
		
		Resources res =getResources(); 
        list=(ListView)findViewById(R.id.list);
        
        /**************** Create Custom Adapter *********/
        adapter=new CustomAdapter(CustomListViewAndroidExample.this, CategoryItemsArray, CoursesItemsArray,res);
        list.setAdapter(adapter);
		
	}

	/****** Function to set data in ArrayList *************/
    public void setCategoryData()
    {
    	
		for (int i = 0; i < 4; i++) {
			
			final ListModel sched = new ListModel();
			    
			  /******* Firstly take data in model object ******/
			   sched.setCompanyName("Category "+i);
			   sched.setImage("image"+i);
			   sched.setUrl("http:\\\\www."+i+".com");
			   
			/******** Take Model Object in ArrayList **********/
			CategoryItemsArray.add(sched);
		}
		
    }
    
	/****** Function to set data in ArrayList *************/
    public void setCoursesData()
    {
    	
		for (int i = 0; i < 4; i++) {
			
			final ListModel sched = new ListModel();
			    
			  /******* Firstly take data in model object ******/
			   sched.setCompanyName("Course "+i);
			   sched.setImage("image"+i);
			   sched.setUrl("http:\\\\www."+i+".com");
			   
			/******** Take Model Object in ArrayList **********/
			CoursesItemsArray.add(sched);
		}
		
    }
    
    public void onItemClick(int mPosition)
    {
    	ListModel tempValues = (ListModel) CategoryItemsArray.get(mPosition);
    	
    	Toast.makeText(CustomListViewAndroidExample.this, 
    			""+tempValues.getCompanyName()+" \nImage:"+tempValues.getImage()+" \nUrl:"+tempValues.getUrl(), 
    			Toast.LENGTH_LONG)
    	.show();
    }
   

}
