package chapter.two.hello_world;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class AlienContact extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    	Button aliensButton = (Button)findViewById(R.id.findAliens);
    	aliensButton.setOnClickListener(new View.OnClickListener(){
    		@Override
    		public void onClick(View v) {
    			listAliens(); }		
    	});	
    	Button spockButton = (Button)findViewById(R.id.addSpock);
    	spockButton.setOnClickListener(new View.OnClickListener(){
    		@Override
    		public void onClick(View v) {
    			addToAlliance("Spock"); }		
    	});	
    	Button worfButton = (Button)findViewById(R.id.addWorf);
    	worfButton.setOnClickListener(new View.OnClickListener(){
    		@Override
    		public void onClick(View v) {
    			addToAlliance("Worf"); }		
    	});	
    	Button homeButton = (Button)findViewById(R.id.returnHome);
    	homeButton.setOnClickListener(new View.OnClickListener(){
    		@Override
    		public void onClick(View v) {
    			finish(); }		
    	});	
    }
	protected void addToAlliance(String newAlien) {
		ContentValues alienContact = new ContentValues();
		alienContact.put(RawContacts.ACCOUNT_NAME, newAlien);
		alienContact.put(RawContacts.ACCOUNT_TYPE, newAlien);
		Uri addUri = getContentResolver().insert(RawContacts.CONTENT_URI, alienContact);
		long rawContactId = ContentUris.parseId(addUri);
		alienContact.clear();
		alienContact.put(Data.RAW_CONTACT_ID, rawContactId);
		alienContact.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
		alienContact.put(StructuredName.DISPLAY_NAME, newAlien);
		getContentResolver().insert(Data.CONTENT_URI, alienContact);
		Toast.makeText(this, "New Alliance Member: " + newAlien, Toast.LENGTH_SHORT).show();
	}
	protected void listAliens() {
		Cursor alienCur = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		while (alienCur.moveToNext()) {
		String alienName = alienCur.getString(alienCur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
		Toast.makeText(this, alienName, Toast.LENGTH_SHORT).show();
		}
		alienCur.close();
	}
}
