package admu.edu.cs119;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class HobbiesScreen extends Activity implements OnClickListener {
	
	public static final int OK = 0;
	public static final int CANCEL = 1;

	private ArrayList<String> hobbies = new ArrayList<String>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hobby_screen);
        

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);    		

        hobbies.clear();

    	Intent intent = getIntent();
    	String hobbyString = intent.getStringExtra(Screen2.HOBBIES);
    	if (!hobbyString.equals("None"))
    	{
    		String[] data = hobbyString.split("\n");
    		for (String s : data)
    		{
    			hobbies.add(s);
    		}
    		
            if (hobbies.contains(checkBox1.getText()))
            {
            	checkBox1.setChecked(true);
            }
            if (hobbies.contains(checkBox2.getText()))
            {
            	checkBox2.setChecked(true);
            }

            if (hobbies.contains(checkBox3.getText()))
            {
            	checkBox3.setChecked(true);
            }

            if (hobbies.contains(checkBox4.getText()))
            {
            	checkBox4.setChecked(true);
            }
    	}
    	
    	// initialize listeners
    	checkBox1.setOnClickListener(this);
    	checkBox2.setOnClickListener(this);
    	checkBox3.setOnClickListener(this);
    	checkBox4.setOnClickListener(this);
    }
    
    public void onClick(View v)
    {
    	CheckBox cb = (CheckBox) v;
    	String name = (String) cb.getText();
    	
    	if (cb.isChecked())
    	{
    		hobbies.add(name);
    	}
    	else
    	{
    		hobbies.remove(name);
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu4, menu);
      return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //Handle item selection using item.getItemId()
       switch(item.getItemId())
       {
       		case R.id.done:
       			done();
       			break;
       			
       		case R.id.cancel:
       			cancel();
       			break;
       }
    	
       return true;
    }

    private void done()
    {

    	Intent intent = getIntent();
    	
    	if (hobbies.size()>0)
    	{
        	StringBuffer sb = new StringBuffer();
	    	for (int i=0; i<hobbies.size(); i++)
	        {
	    		sb.append(hobbies.get(i));
	    		if (i<hobbies.size()-1)
	    		{
		    		sb.append("\n");	    			
	    		}
	        }
	    	
	    	intent.putExtra(Screen2.HOBBIES, sb.toString());	    	
    	}
    	else
    	{
	    	intent.putExtra(Screen2.HOBBIES, "None");	    	    		
    	}
    	
    	setResult(OK, intent);
    	finish();    	
    }
    
    private void cancel()
    {
    	setResult(CANCEL);
    	finish();
    }
    
    
    public void onBackPressed()
    {
    	cancel();
    	super.onBackPressed();
    }
}