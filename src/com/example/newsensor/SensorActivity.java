package com.example.newsensor;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SensorActivity extends Activity implements SensorEventListener{
	
	TextView textView;
	SensorManager sensorManager;
	Sensor sensor;
	Sensor sensor2;
	float prox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor);

		textView =(TextView) findViewById(R.id.textView2);
		sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensor= sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		sensor2= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//		prox=sensor.getMaximumRange();
	
	}
	@Override
	protected void onPause(){
		super.onPause();
		sensorManager.unregisterListener(this);
	}
	@Override
	protected void onResume(){
		super.onResume();
		sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(this, sensor2, SensorManager.SENSOR_DELAY_NORMAL);
		
	}
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
	
		if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
			textView.setText("" + event.values[0]+System.getProperty("line.separator") );
		}
		if(event.values[0]==0){
			
			stopService(new Intent(this,MyService.class));
			
		}
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
			textView.setText("" + event.values[0]+System.getProperty("line.separator")+ event.values[1]+System.getProperty("line.separator")+ event.values[2] );
			
		}
		
		
	}
	
	@Override
	protected void onStop(){
		super.onStop();
//		sensorManager.unregisterListener(this);
	}




}
