package com.example.lenc.fitnesdnevnik;

import android.content.Intent;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ActivityCasKardio extends AppCompatActivity {

    private Button zacni;
    private Button koncaj;
    private Button shrani;
    private Button reset;
    private TextView cas;
    public Chronometer chronometer;
    ApplicationMy app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cas_kardio);
        Intent that = getIntent();
        String flj = that.getStringExtra("Vaja");
        TextView tv = (TextView) findViewById(R.id.textViewVaja);
        tv.setText(flj);

        app= (ApplicationMy) getApplication();
        reset=(Button)findViewById(R.id.buttonReset);
        zacni = (Button) findViewById(R.id.buttonZacni);
        koncaj =(Button)findViewById(R.id.buttonKoncaj);
        shrani=(Button)findViewById(R.id.buttonShrani);
        cas=(TextView)findViewById(R.id.textViewKoncniCas);
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
        app.save();
    }
}