package admu.cs119;

import android.app.Application;

public class CustomApplication extends Application 
{
	String hello = "Custom Data";
	
	public String getCustomData()
	{
		return hello;
	}
}
