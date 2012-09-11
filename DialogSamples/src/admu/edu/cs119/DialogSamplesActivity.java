package admu.edu.cs119;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class DialogSamplesActivity extends Activity {
	
	public static final int DATE_DIALOG = 0;
	public static final int TIME_DIALOG = 1;
	public static final int ALERT_DIALOG1 = 2;
	public static final int ALERT_DIALOG2 = 3;
	public static final int ALERT_DIALOG3 = 4;
	public static final int ALERT_DIALOG4 = 5;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				showDialog(DATE_DIALOG);
			}
		});
        
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				showDialog(TIME_DIALOG);				
			}
		});
        
        Button b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				showDialog(ALERT_DIALOG1);				
			}
		});

        Button b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				showDialog(ALERT_DIALOG2);				
			}
		});

        Button b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				showDialog(ALERT_DIALOG3);				
			}
		});

        Button b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				showDialog(ALERT_DIALOG4);				
			}
		});

    } 
    
    public Dialog onCreateDialog(int id)
    {
    	Dialog d = null;
    	Calendar cal = Calendar.getInstance();
    	switch(id)
    	{
	    	case DATE_DIALOG:
	    		System.out.println("onCreate id="+id);
	    		d = createDateDialog(cal);
	    		break;
	    	
	    	case TIME_DIALOG:
	    		System.out.println("onCreate id="+id);
	    		d = createTimeDialog(cal);
	    		break;
	    		
	    	case ALERT_DIALOG1:
	    		d = createAlertDialog1();
	    		break;

	    	case ALERT_DIALOG2:
	    		d = createAlertDialog2();
	    		break;

	    	case ALERT_DIALOG3:
	    		d = createAlertDialog3();
	    		break;

	    	case ALERT_DIALOG4:
	    		d = createAlertDialog4();
	    		break;

    	}
    	
    	return d;
    }

	private Dialog createAlertDialog1() 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Press a button?")
		       .setCancelable(false)
		       .setPositiveButton("Left", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) 
		           {
		        	    System.out.println("PRESSED LEFT");
		                dialog.dismiss();
		           }
		       })
		       .setNegativeButton("Right", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) 
		           {
		        	    System.out.println("PRESSED RIGHT");
		                dialog.dismiss();
		           }
		       });
		AlertDialog alert = builder.create();
		return alert;
	}

	private Dialog createAlertDialog2() {
		final CharSequence[] items = {"Red", "Green", "Blue"};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a color");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) 
		    {
		        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
		    }
		});
		AlertDialog alert = builder.create();
		return alert;
	}

	private Dialog createAlertDialog3() {
		final CharSequence[] items = {"Red", "Green", "Blue"};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a color");
		builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
		    }
		});
		AlertDialog alert = builder.create();		
		return alert;
	}

	private Dialog createAlertDialog4() {
		final CharSequence[] items = {"Red", "Green", "Blue"};
		final boolean[] select = {true, false, true};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a color");
		builder.setMultiChoiceItems(items, select, new DialogInterface.OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) 
			{
		        Toast.makeText(getApplicationContext(), items[which], Toast.LENGTH_SHORT).show();
			}
		});
		AlertDialog alert = builder.create();		
		return alert;
	}

	private Dialog createTimeDialog(Calendar cal) 
	{
		Dialog d;
		OnTimeSetListener timeCallBack = new OnTimeSetListener() 
		{
			@Override
			public void onTimeSet(TimePicker view, int hour, int minute)
			{
				System.out.println(hour+":"+minute);
			}
		};

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		d = new TimePickerDialog(this, timeCallBack, hour, minute, true);
		return d;
	}

	private Dialog createDateDialog(Calendar cal) 
	{
		Dialog d;
		OnDateSetListener dateCallBack = new OnDateSetListener() 
		{
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) 
			{
				System.out.println(monthOfYear+"/"+dayOfMonth+"/"+year);
			}
		};

		int year = cal.get(Calendar.YEAR);
		int monthOfYear = cal.get(Calendar.MONTH);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		d = new DatePickerDialog(this, 
								 dateCallBack, 
								 year, 
								 monthOfYear, 
								 dayOfMonth);
		return d;
	}

    public void onPrepareDialog(int id, Dialog d)
    {
		System.out.println("onPrepare id="+id);
    	switch(id)
    	{
	    	case DATE_DIALOG:
	    		break;

	    	case TIME_DIALOG:
	    		break;
	    		
	    	case ALERT_DIALOG1:
	    		break;

	    	case ALERT_DIALOG2:
	    		break;

	    	case ALERT_DIALOG3:
	    		break;

	    	case ALERT_DIALOG4:
	    		break;

    	}
    	
    }
}