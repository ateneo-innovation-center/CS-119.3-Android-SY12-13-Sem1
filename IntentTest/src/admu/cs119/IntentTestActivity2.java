package admu.cs119;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class IntentTestActivity2 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        Intent intent = getIntent();
        
        TextView text = (TextView) findViewById(R.id.text1);        
        text.setText("Received "+intent.getStringExtra("PARAMS"));
        
        Button b = (Button) findViewById(R.id.button1);
        
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				closeAction();
			}
		});
        
        CustomApplication app = (CustomApplication) getApplication();
        System.out.println(app.getCustomData());

    }
    
    private void closeAction()
    {
    	Intent intent = getIntent();    	
    	intent.putExtra("RETVAL", "LOOK AT RETURN VAL");
    	
    	setResult(0, intent);
    	finish();
    }
}