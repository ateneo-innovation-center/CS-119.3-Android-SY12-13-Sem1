package admu.cs119;

import android.app.Activity;
import android.os.Bundle;

public class ActivityLifeCycleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        System.out.println("onCreate() "+savedInstanceState);
    }
    
    
    @Override
    public void onStart()
    {
    	super.onStart();
    	System.out.println("onStart()");
    }
    
    @Override
    public void onRestart()
    {
    	super.onRestart();
    	System.out.println("onRestart()");    	    	    	
    }
    
    @Override
    public void onResume()
    {
    	super.onResume();
    	System.out.println("onResume()");    	
    }
    
    @Override
    public void onPause()
    {
    	super.onPause();
    	System.out.println("onPause()");    	
    }

    @Override
    public void onStop()
    {
    	super.onStop();
    	System.out.println("onStop()");    	
    }

    @Override
    public void onDestroy()
    {
    	super.onDestroy();
    	System.out.println("onDestroy()");    	
    }

    
    @Override
    public void onSaveInstanceState(Bundle b)
    {
    	b.putString("VALUE", "HERE I AM");
    	System.out.println("onSaveInstanceState()");    	
    }
}