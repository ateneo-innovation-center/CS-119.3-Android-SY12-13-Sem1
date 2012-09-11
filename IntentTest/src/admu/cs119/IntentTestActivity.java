package admu.cs119;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class IntentTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b = (Button) findViewById(R.id.button1);
        
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				nextAction();
			}
		});
        
        Button b2 = (Button) findViewById(R.id.button2);
        
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				nextActionWithResult();
			}
		});

        CustomApplication app = (CustomApplication) getApplication();
        System.out.println(app.getCustomData());
        
    }
    
    private void nextAction()
    {
        TextView text = (TextView) findViewById(R.id.text1);        
        text.setText("Not expecting result");	

    	
		Intent intent = new Intent(this, IntentTestActivity2.class);        
		intent.putExtra("PARAMS", "MY PARAMS"); 
		startActivity(intent);
    }
    
    private void nextActionWithResult()
    {
        TextView text = (TextView) findViewById(R.id.text1);        
        text.setText("Waiting for result");	

    	
		Intent intent = new Intent(this, IntentTestActivity2.class);        
		intent.putExtra("PARAMS", "MY PARAMS"); 
		startActivityForResult(intent, 0);
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        TextView text = (TextView) findViewById(R.id.text1);        
        text.setText("Returned "+data.getStringExtra("RETVAL"));	
    }

}