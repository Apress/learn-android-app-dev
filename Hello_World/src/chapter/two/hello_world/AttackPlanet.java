package chapter.two.hello_world;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
public class AttackPlanet extends Activity {
private SoundPool soundPoolFX;
private SparseIntArray soundPoolMap;
int sample1 = 1;
int sample2 = 2;
int sample3 = 3;
int sample4 = 4;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_attack);
	soundPoolFX = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
	soundPoolMap = new SparseIntArray(4);
	soundPoolMap.append(sample1, soundPoolFX.load(this, R.raw.blast, 1));
	soundPoolMap.append(sample2, soundPoolFX.load(this, R.raw.transport, 1));
	soundPoolMap.append(sample3, soundPoolFX.load(this, R.raw.virus, 1));
	soundPoolMap.append(sample4, soundPoolFX.load(this, R.raw.laser, 1));	
	ImageButton bombButton = (ImageButton)findViewById(R.id.bombButton);
	Animation rotateBomb = AnimationUtils.loadAnimation(this,R.anim.anim_rot_bomb);
	bombButton.startAnimation(rotateBomb);
	bombButton.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Toast.makeText(AttackPlanet.this, "Bombs Away!", Toast.LENGTH_SHORT).show();
			playSample(sample1, 1.0f);
		}		
	});
	ImageView invadeEffect = (ImageView)findViewById(R.id.invadeEffect);
	AnimationDrawable transporterEffect = (AnimationDrawable) invadeEffect.getBackground();
	transporterEffect.start();
	ImageButton invadeButton = (ImageButton)findViewById(R.id.invadeButton);
	Animation alphaInvade = AnimationUtils.loadAnimation(this,R.anim.anim_alpha_invade);
	invadeButton.startAnimation(alphaInvade);
	invadeButton.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Toast.makeText(AttackPlanet.this, "Troops Sent", Toast.LENGTH_SHORT).show();
			playSample(sample2, 1.0f);
		}		
	});			
	ImageButton infectButton = (ImageButton)findViewById(R.id.infectButton);
	Animation scaleVirus = AnimationUtils.loadAnimation(this,R.anim.anim_scale_virus);
	infectButton.startAnimation(scaleVirus);	
	infectButton.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Toast.makeText(AttackPlanet.this, "Virus Spread", Toast.LENGTH_SHORT).show();
			playSample(sample3, 1.0f);
		}		
	});			
	ImageButton laserButton = (ImageButton)findViewById(R.id.laserButton);
	Animation translateLaser = AnimationUtils.loadAnimation(this,R.anim.anim_trans_laser);
	laserButton.startAnimation(translateLaser);
	laserButton.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Toast.makeText(AttackPlanet.this, "Laser Fired!", Toast.LENGTH_SHORT).show();
			playSample(sample4, 1.0f);
		}		
	});			
	ImageButton exitButton = (ImageButton)findViewById(R.id.exitButton);
	exitButton.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) { finish(); }		
	});			
 }
public void playSample (int sample, float pitchShift) {
	AudioManager manageAudio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
	float curSampleVolume = manageAudio.getStreamVolume(AudioManager.STREAM_MUSIC);
	float maxSampleVolume = manageAudio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
	float setSampleVolume = curSampleVolume / maxSampleVolume;
	soundPoolFX.play(soundPoolMap.get(sample), setSampleVolume, setSampleVolume, 0, 0, pitchShift);
}
}