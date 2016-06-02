package com.example.lenc.fitnesdnevnik;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityUteziPodatki extends AppCompatActivity {

    ApplicationMy app;
    public TextView tvPonovitve ;
    public int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utezi_podatki);
        app= (ApplicationMy) getApplication();
        Intent that = getIntent();
        String flj = that.getStringExtra("Vaja");
        TextView tv = (TextView) findViewById(R.id.textViewVaja);
        tvPonovitve= (TextView) findViewById(R.id.textViewSerije);
        Button dodaj =(Button)findViewById(R.id.buttonDodajSerije);
        tv.setText(flj);
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                tvPonovitve.setText(String.valueOf(i));
            }
        });

    }
    public void buttonShraniUteziOnClick(View v){
        app.save();

    }
    public void buttonResetirajOnClick(View v){
        tvPonovitve.setText("0");
        i=0;
    }
}
