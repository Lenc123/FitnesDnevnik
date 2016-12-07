package com.example.lenc.fitnesdnevnik;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ActivityCasKardio extends AppCompatActivity implements SensorEventListener {

    private Button zacni;
    private Button koncaj;
    private Button shrani;
    private Button reset;
    private Button prikazi;
    private TextView cas;
    private TextView koraki;
    public String flj;
    public Chronometer chronometer;
    ApplicationMy app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cas_kardio);
        Intent that = getIntent();
        flj = that.getStringExtra("Vaja");
        TextView tv = (TextView) findViewById(R.id.textViewVaja);
        tv.setText(flj);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        app= (ApplicationMy) getApplication();
        reset=(Button)findViewById(R.id.buttonReset);
        zacni = (Button) findViewById(R.id.buttonZacni);
        koncaj =(Button)findViewById(R.id.buttonKoncaj);
        shrani=(Button)findViewById(R.id.buttonShrani);
        prikazi=(Button)findViewById(R.id.buttonPrikazi);
        cas=(TextView)findViewById(R.id.textViewKoncniCas);
        koraki =(TextView)findViewById(R.id.textViewKoraki);
        chronometer=(Chronometer)findViewById(R.id.chronometer);
        chronometer.setText("00:00:00");
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                CharSequence text = chronometer.getText();
                if(text.length() == 5){
                    chronometer.setText("00:"+text);
                }
                else if(text.length()==7){
                    chronometer.setText("0"+text);
                }
            }
        });
    }
    public void start(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        chronometer.setText("00:00:00");
        koraki.setText("0");
        return;
    }
    public void stop(View view){
        chronometer.stop();
        cas.setText(chronometer.getText());
    }
    public void restart(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        cas.setText("");
        chronometer.setText("00:00:00");
    }
    public void buttonShraniOnClick(View v){
        app.getAll().getKardioFilter(flj).setCas(cas.getText().toString());
        app.save();
        chronometer.setBase(SystemClock.elapsedRealtime());
        cas.setText("");
        chronometer.setText("00:00:00");
        Toast toast = Toast.makeText(getApplicationContext(), "Podatki uspešno shranjeni v datoteko", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void buttonPrikaziOnClick(View v){
        Intent intentMaps = new Intent(this,MapsActivity.class);
        startActivity(intentMaps);
    }
    private SensorManager sensorManager;
    boolean activityRunning;

    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityRunning = false;
        // if you unregister the last listener, the hardware will stop detecting step events
//        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (activityRunning) {
            koraki.setText(String.valueOf(event.values[0]));
        }

    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}