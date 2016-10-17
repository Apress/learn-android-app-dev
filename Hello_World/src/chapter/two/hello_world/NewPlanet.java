package chapter.two.hello_world;
import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
public class NewPlanet extends Activity {
private MediaPlayer marsPlayer = null;	
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_add);

	final TransitionDrawable trans = (TransitionDrawable)getResources().getDrawable(R.drawable.tran_stars_galaxy);
	RelativeLayout newPlanetScreen = (RelativeLayout)findViewById(R.id.new_planet_screen);
	newPlanetScreen.setBackground(trans);
	
	Button doneButton = (Button)findViewById(R.id.doneAddingButton);
	doneButton.setOnClickListener(new View.OnClickListener(){
		@Override
		public void onClick(View v) {
			finish();	
		}
	});
	ImageView marsImage = (ImageView)findViewById(R.id.imageMars);
	marsPlayer = MediaPlayer.create(this, R.raw.mars);	
	marsImage.setOnClickListener(new View.OnClickListener(){
		@Override
		public void onClick(View v) {
			 WorldGen mars = new WorldGen("Mars", 642, 3.7);
			 mars.setPlanetColonies(1);
			 Toast.makeText(NewPlanet.this, "Mars Created", Toast.LENGTH_SHORT).show();
			 trans.startTransition(5000);
			 marsPlayer.start();
		}		
	});
  }
}
