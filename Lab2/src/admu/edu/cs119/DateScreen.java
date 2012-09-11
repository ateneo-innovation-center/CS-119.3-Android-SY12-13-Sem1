package admu.edu.cs119;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class DateScreen extends Activity {
	
	public static final int OK = 0;
	public static final int CANCEL = 1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_screen);
        
    	Intent intent = getIntent();
    	String bdayString = intent.getStringExtra(Screen2.BIRTHDAY);
    	if (!bdayString.equals("None Set"))
    	{
            // split the date string by "/"
    		String[] comp = bdayString.split("/");
            EditText editText1 = (EditText) findViewById(R.id.editText1);
            editText1.setText(comp[0]);
            EditText editText2 = (EditText) findViewById(R.id.editText2);
            editText2.setText(comp[1]);
            EditText editText3 = (EditText) findViewById(R.id.editText3);
            editText3.setText(comp[2]);
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
    	
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);

        String month = editText1.getText().toString();
        String day   = editText2.getText().toString();
        String year  = editText3.getText().toString();
        
        if (month.equals("") || (day.equals("")) || (year.equals("")))
        {
        }
        else
        {
	    	String bdayString = month+"/"+day+"/"+year;
	    	intent.putExtra(Screen2.BIRTHDAY, bdayString);	    	
	    	setResult(OK, intent);
	    	finish();    	
        }
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