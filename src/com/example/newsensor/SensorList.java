package com.example.newsensor;


import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SensorList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_list);
		TextView text =(TextView)findViewById(R.id.textView1);
		SensorManager manager =(SensorManager) this.getSystemService(SENSOR_SERVICE);
		List<Sensor> sensors =manager.getSensorList(Sensor.TYPE_ALL);
		StringBuilder message = new StringBuilder();
		message.append("Sensors on this device are: \n\n");
		
	 for(Sensor sensor : sensors){
			message.append("Name: " + sensor.getName() + "\n\n");
	 }
	 text.setText(message);
	 
	}

	


}
