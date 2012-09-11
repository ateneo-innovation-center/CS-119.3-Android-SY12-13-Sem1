package admu.edu.cs119;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Screen1 extends Activity {
	
	public static final String NAME = "NAME"; 
	public static final String ADDRESS = "ADDRESS"; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen1);
        
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        
        // initialize
        Intent intent = getIntent();
        String name = intent.getStringExtra(NAME);
        if (name!=null)
        {
        	editText1.setText(name);
        }

        String address = intent.getStringExtra(ADDRESS);
        if (address!=null)
        {
        	editText2.setText(address);
        }

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu1, menu);
      return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //Handle item selection using item.getItemId()
       switch(item.getItemId())
       {
       		case R.id.next:
       			next();
       			break;
       			
       		case R.id.exit:
       			exit();
       			break;
       }
    	
       return true;
    }

    private void next()
    {
    	Intent intent = new Intent(this, Screen2.class);

    	intent.putExtras(getIntent());

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

    	intent.putExtra(NAME, editText1.getText().toString());
    	intent.putExtra(ADDRESS, editText2.getText().toString());
    	
    	finish();

    	startActivity(intent);
    }
    
    private void exit()
    {
    	finish();
    }
    
    public void onBackPressed()
    {
    	exit();
    	super.onBackPressed();
    }
    
}