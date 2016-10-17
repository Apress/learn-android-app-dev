package chapter.two.hello_world;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;
public class MusicService extends Service {
	MediaPlayer musicPlayer;
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	@Override
	public void onCreate() {
		Toast.makeText(this, "Music Service has been Created", Toast.LENGTH_SHORT).show();
		musicPlayer = MediaPlayer.create(this, R.raw.music);
		musicPlayer.setLooping(true);
	}
	@Override
	public void onStart(Intent intent, int startid) {
		Toast.makeText(this, "Music Service is Started", Toast.LENGTH_SHORT).show();
		musicPlayer.start();
	}
	@Override
	public void onDestroy() {
		Toast.makeText(this, "Music Service has been Stopped", Toast.LENGTH_LONG).show();
		musicPlayer.stop();
	}
}
