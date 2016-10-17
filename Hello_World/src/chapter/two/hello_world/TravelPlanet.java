package chapter.two.hello_world;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
public class TravelPlanet extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_travel);
	Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mars270);
	VideoView travelVideo = (VideoView)findViewById(R.id.travelVideoView);
	travelVideo.setVideoURI(videoUri);
	MediaController videoMediaController = new MediaController(this);
	videoMediaController.setAnchorView(travelVideo);
	travelVideo.setMediaController(videoMediaController);
	travelVideo.bringToFront();
	travelVideo.requestFocus();
	travelVideo.start();
	Button travelButton = (Button)findViewById(R.id.travelButton);
	travelButton.setOnClickListener(new View.OnClickListener(){
		@Override
		public void onClick(View v) {
			Toast.makeText(TravelPlanet.this, "Going Home", Toast.LENGTH_SHORT).show();
			finish();
		}
	});
  }
}