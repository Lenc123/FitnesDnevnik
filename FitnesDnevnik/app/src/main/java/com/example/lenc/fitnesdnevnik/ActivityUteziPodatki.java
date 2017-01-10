package com.example.lenc.fitnesdnevnik;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityUteziPodatki extends AppCompatActivity {

    ApplicationMy app;
    public TextView tvPonovitve ;
    public TextView tvSerije;
    public int i=0;
    public int j=0;
    private String flj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utezi_podatki);
        app= (ApplicationMy) getApplication();
        Intent that = getIntent();
        flj = that.getStringExtra("Vaja");
        TextView tv = (TextView) findViewById(R.id.textViewVaja);
        tvPonovitve = (TextView)findViewById(R.id.textViewPonovitve);
        tvSerije= (TextView) findViewById(R.id.textViewSerije);
        Button dodaj =(Button)findViewById(R.id.buttonDodajSerije);
        Button dodajPonovitve =(Button)findViewById(R.id.buttonDodajPonovitve);
        tv.setText(flj);
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                tvSerije.setText(String.valueOf(i));
            }
        });
        dodajPonovitve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j++;
                tvPonovitve.setText(String.valueOf(j));
            }
        });

    }
    public void buttonShraniUteziOnClick(View v){
        app.save();
        app.getAll().getUteziFilter(flj).setSerije(tvSerije.getText().toString());
        app.getAll().getUteziFilter(flj).setPonovitve((tvPonovitve.getText().toString()));
        tvSerije.setText("0");
        tvPonovitve.setText("0");
        i=0;
        Toast toast = Toast.makeText(getApplicationContext(), "Podatki uspešno shranjeni v datoteko", Toast.LENGTH_SHORT);
        toast.show();

    }
    public void buttonResetirajOnClick(View v){
        tvSerije.setText("0");
        tvPonovitve.setText("0");
        i=0;
    }
}
