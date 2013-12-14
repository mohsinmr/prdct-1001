package com.example.databaseGenerator;

import java.util.Hashtable;

import android.app.Application;

public class SSCApplication extends Application{
	private Hashtable<String, Object> sessBag = new Hashtable<String, Object>();
	private String str_mode = null;
	private boolean bln_DBCreated = false;
	public String getMode()
	{
		return str_mode;
	}
	public void setMode(String str_Mode)
	{
		str_mode=str_Mode;
	}
	public boolean getDBCreated()
	{
		return bln_DBCreated;
	}
	public void setDBCreated(boolean value)
	{
		this.bln_DBCreated = value;
	}
	public void setSessBag(Hashtable<String, Object> sessBag) {
		this.sessBag = sessBag;
	}
	public Hashtable<String, Object> getSessBag() {
		return sessBag;
	}
}
