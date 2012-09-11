package admu.edu.cs119;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Screen2 extends Activity {
	
	public static final String GENDER = "GENDER"; 
	public static final String BIRTHDAY = "BIRTHDAY"; 
	public static final String HOBBIES = "HOBBIES"; 
	
	public static final int BIRTHDAY_SCREEN = 0;
	public static final int HOBBY_SCREEN = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen2);
        
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        
        // initialize
        Intent intent = getIntent();
        String gender = intent.getStringExtra(GENDER);
        if (gender!=null)
        {
        	if (gender.equals("Male"))
        	{
        		radioGroup.check(R.id.radio0);
        	}
        	else
        	{
        		radioGroup.check(R.id.radio1);        		
        	}
        }

        String birthday = intent.getStringExtra(BIRTHDAY);
        if (birthday!=null)
        {
        	textView3.setText(birthday);
        }

        String hobbies = intent.getStringExtra(HOBBIES);
        if (hobbies!=null)
        {
        	textView5.setText(hobbies);
        }
        
        // initialize buttons
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				openBirthday();
			}
		});
        
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				openHobbies();
			}
		});

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu2, menu);
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
       			
       		case R.id.previous:
       			previous();
       			break;
       }
    	
       return true;
    }
    
    private void openBirthday()
    {
    	Intent intent = new Intent(this, DateScreen.class);

        TextView textView3 = (TextView) findViewById(R.id.textView3);
    	intent.putExtra(BIRTHDAY, textView3.getText());
    	
    	startActivityForResult(intent, BIRTHDAY_SCREEN);
    }

    private void openHobbies()
    {
    	Intent intent = new Intent(this, HobbiesScreen.class);

        TextView textView5 = (TextView) findViewById(R.id.textView5);
    	intent.putExtra(HOBBIES, textView5.getText());
    	
    	startActivityForResult(intent, HOBBY_SCREEN);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	switch(requestCode)
    	{
    		case BIRTHDAY_SCREEN:
				if (resultCode==DateScreen.OK)
				{
			        TextView textView3 = (TextView) findViewById(R.id.textView3);
			        textView3.setText(data.getStringExtra(BIRTHDAY));    				
				}
				break;
    		case HOBBY_SCREEN:
    			if (resultCode==HobbiesScreen.OK)
    			{
    		        TextView textView5 = (TextView) findViewById(R.id.textView5);
    		        textView5.setText(data.getStringExtra(HOBBIES));
    			}
    			break;
    	}
    }
    
    private void next()
    {
    	Intent intent = new Intent(this, Screen3.class);

    	intent.putExtras(getIntent());

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView5 = (TextView) findViewById(R.id.textView5);

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        if (radioButtonId!=-1)
        {
	        RadioButton radioButton = (RadioButton) findViewById(radioButtonId);
	    	intent.putExtra(GENDER, radioButton.getText());
        }
        
    	intent.putExtra(BIRTHDAY, textView3.getText());
    	intent.putExtra(HOBBIES, textView5.getText());
    	
    	finish();

    	startActivity(intent);
    }
    
    private void previous()
    {
    	Intent intent = new Intent(this, Screen1.class);

    	intent.putExtras(getIntent());

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView5 = (TextView) findViewById(R.id.textView5);

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        if (radioButtonId!=-1)
        {
	        RadioButton radioButton = (RadioButton) findViewById(radioButtonId);
	    	intent.putExtra(GENDER, radioButton.getText());
        }
        
    	intent.putExtra(BIRTHDAY, textView3.getText());
    	intent.putExtra(HOBBIES, textView5.getText());
    	
    	finish();

    	startActivity(intent);
    }
    
    public void onBackPressed()
    {
    	previous();
    	super.onBackPressed();
    }

}