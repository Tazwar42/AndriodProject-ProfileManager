package com.example.newsensor;


import java.util.List;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
	
	Button sensorList,start,stop,proximity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 btnCast();
		 sensorList.setOnClickListener(this);
		 start.setOnClickListener(this);
		 stop.setOnClickListener(this);
		 proximity.setOnClickListener(this);
		 
		 
	//	 MediaPlayer player = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI );
	//	 player.setLooping(true);
	//	 player.start();

		 
	}
	
	
	public void btnCast(){
	
		sensorList=(Button) findViewById(R.id.button1);
		start=(Button) findViewById(R.id.button2);
		stop=(Button)findViewById(R.id.button3);
		proximity=(Button) findViewById(R.id.button4);
		
		
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1){
			
			Log.d("sam", "btn1");
			Intent intent = new Intent(MainActivity.this, SensorList.class);
			
			startActivity(intent);
        
			
		}
		
		else if(v.getId()==R.id.button2){
			
			Log.d("sam", "btn2");
			startService(new Intent(this,MyService.class));
		}
		else if(v.getId()==R.id.button3){
			
			Log.d("sam", "btn3");
			stopService(new Intent(this,MyService.class));
		}
		else if(v.getId()==R.id.button4){
			
			Log.d("sam", "btn4");
			Intent intent = new Intent(MainActivity.this, SensorActivity.class);
			
			startActivity(intent);
		}
	}
	
	
	
	


}
