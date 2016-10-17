package chapter.two.hello_world;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
	  Toast.makeText(arg0, "ALARM NOTIFICATION", Toast.LENGTH_SHORT).show();
	}
}
