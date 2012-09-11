package admu.edu.cs119;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Screen3 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen3);
        
        TextView textView = (TextView) findViewById(R.id.textView2);
        
        Intent intent = getIntent();
        
        StringBuffer sb = new StringBuffer();
        sb.append("Name="); sb.append(intent.getStringExtra(Screen1.NAME)); sb.append("\n");
        sb.append("Address="); sb.append(intent.getStringExtra(Screen1.ADDRESS)); sb.append("\n");
        sb.append("Gender="); sb.append(intent.getStringExtra(Screen2.GENDER)); sb.append("\n");
        sb.append("Birthday="); sb.append(intent.getStringExtra(Screen2.BIRTHDAY)); sb.append("\n");
        sb.append("Hobbies="); sb.append(intent.getStringExtra(Screen2.HOBBIES)); sb.append("\n");
        
        textView.setText(sb.toString());
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu3, menu);
      return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //Handle item selection using item.getItemId()
       switch(item.getItemId())
       {
       		case R.id.previous:
       			previous();
       			break;
       			
       		case R.id.exit:
       			exit();
       			break;
       }
    	
       return true;
    }
    
    private void previous()
    {
    	Intent intent = new Intent(this, Screen2.class);
    	intent.putExtras(getIntent());
    	startActivity(intent);
    	
    	finish();
    }

    private void exit()
    {
    	finish();
    }
    
    public void onBackPressed()
    {
    	previous();
    	super.onBackPressed();
    }
}