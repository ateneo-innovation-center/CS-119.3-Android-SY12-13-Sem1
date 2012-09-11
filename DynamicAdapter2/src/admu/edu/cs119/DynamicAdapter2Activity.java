package admu.edu.cs119;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DynamicAdapter2Activity extends ListActivity {
	
	private SampleCustomAdapter adapter;
    private ArrayList<MyContact> sampleList;

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);

        sampleList = new ArrayList<MyContact>();
        MyContact c1 = new MyContact();
        c1.setName("ABC");
        c1.setPhone("1234567890");
        c1.setEmail("Name1@name123.com");
        sampleList.add(c1);
        
        MyContact c2 = new MyContact();
        c2.setName("BCD");
        c2.setPhone("1234567890");
        c2.setEmail("Name2@name123.com");
        sampleList.add(c2);

        MyContact c3 = new MyContact();
        c3.setName("DEF");
        c3.setPhone("1234567890");
        c3.setEmail("Name3@name123.com");
        sampleList.add(c3);

        adapter = new SampleCustomAdapter(sampleList);
        
        // EXAMPLE OF A CUSTOM ListActivity layout
        // ListView must have an id EXACTLY like this android:id="@android:id/list"
        
        setContentView(R.layout.main);
        setListAdapter(adapter);
        
        
        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        
        // NOTE: REGISTER listview for context menu
        registerForContextMenu(lv);
        
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
		        MyContact newContact = new MyContact();
		        newContact.setName("NEW");
		        newContact.setPhone("212121212");
		        newContact.setEmail("New@name123.com");
				sampleList.add(newContact);
				adapter.notifyDataSetChanged();
			}
		});
    }
    
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
    	super.onCreateContextMenu(menu, v, menuInfo);
    	MenuInflater inflater = getMenuInflater();
    	
    	// places the contents of the XML to the menu
    	inflater.inflate(R.menu.context_menu, menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
      AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
      switch (item.getItemId()) {
      case R.id.delete:
    	// delete the currently selected row
    	  System.out.println(info.id);
    	  System.out.println(info.position);    
    	  
    	  // NOTE: trigger the changes
    	  sampleList.remove(info.position);
    	  adapter.notifyDataSetChanged();
        return true;
      default:
        return super.onContextItemSelected(item);
      }
    }
    
    
    private class SampleCustomAdapter extends BaseAdapter {

    	private ArrayList<MyContact> internalList;
    	
    	public SampleCustomAdapter(ArrayList<MyContact> contacts)
    	{
    		internalList = contacts;
    	}
    	
    	@Override
    	public int getCount() {
    		// TODO Auto-generated method stub
    		return internalList.size();
    	}

    	@Override
    	public Object getItem(int index) 
    	{
    		// TODO Auto-generated method stub
    		return internalList.get(index);
    	}

    	@Override
    	public long getItemId(int position) {
    		// TODO Auto-generated method stub
    		return position;
    	}

    	@Override
    	public View getView(int position, View convertView, ViewGroup parent) 
    	{
    		// NOTE: you can only do this if you have access to the Activity object
    		//		 which is why this is an inner class
    		LayoutInflater inflater = getLayoutInflater();
    		View view;
    		
            System.out.println(parent.getClass().getName());
            System.out.println(position);

    		
    		if (convertView==null)
    		{
    			view = inflater.inflate(R.layout.row, null);
    		}
    		else
    		{
    			view = convertView;
    		}
    		
    		// extract the views to be populated
    		TextView name = (TextView) view.findViewById(R.id.name);
    		TextView phone = (TextView) view.findViewById(R.id.phone);
    		TextView email = (TextView) view.findViewById(R.id.email);
    		
    		// extract the object that will fill these
    		MyContact contact = internalList.get(position);
    		
    		name.setText(contact.getName());
    		phone.setText(contact.getPhone());
    		email.setText(contact.getEmail());
    		
    		
    		// return the view
    		return view;
    	}
    }
    
    
    
    
}