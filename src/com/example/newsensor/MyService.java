package com.example.newsensor;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class MyService extends Service implements SensorEventListener{
	
	private MediaPlayer player;
	SensorManager sensorManager;
	Sensor sensor;
	Sensor sensor2;
	float prox;

	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent,int  flags,int  startId){
	//	 super.onStartCommand(intent, flags, startId);
		Log.d("sam", "yahooo");
		 sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
		 sensor= sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		 sensor2= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		 
		 player = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI );
		 player.setLooping(true);
		 player.start();
		 sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
		 sensorManager.registerListener(this, sensor2, SensorManager.SENSOR_DELAY_NORMAL);
		 return START_STICKY;
	}
	
	
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		
		player.stop();
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
	//	if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
			//textView.setText("" + event.values[0]);
	//	}
//		sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
		if(event.sensor.getType()==Sensor.TYPE_PROXIMITY & event.values[0]==0){
			
			stopService(new Intent(this,MyService.class));
			
		}
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER & event.values[2]<0){
			
		//	stopService(new Intent(this,MyService.class));
			AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
			audio.setRingerMode(0);
			 
			
			
		}
		
	}
	

}
