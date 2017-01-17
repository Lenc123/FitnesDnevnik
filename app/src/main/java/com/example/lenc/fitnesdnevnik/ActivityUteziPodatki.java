package com.example.lenc.fitnesdnevnik;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityUteziPodatki extends AppCompatActivity {

    ApplicationMy app;
    public TextView tvPonovitve ;
    public TextView tvSerije;
    public int i=0;
    private String flj;
    NumberPicker np, np1;
    Button save, reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utezi_podatki);
        app= (ApplicationMy) getApplication();
        Intent that = getIntent();
        flj = that.getStringExtra("Vaja");
        TextView tv = (TextView) findViewById(R.id.textViewVaja);
        np = (NumberPicker) findViewById(R.id.numberPicker1);
        np1 = (NumberPicker) findViewById(R.id.numberPicker2);
        save = (Button)findViewById(R.id.buttonShraniUtezi);
        reset =(Button)findViewById(R.id.buttonReset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                np.setValue(0);
                np1.setValue(0);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app.save();
                // app.getAll().getUteziFilter(flj).setSerije(tvSerije.getText().toString());
                // app.getAll().getUteziFilter(flj).setPonovitve((tvPonovitve.getText().toString()));
                i=0;
                Toast toast = Toast.makeText(getApplicationContext(), "Podatki uspešno shranjeni v datoteko", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        np.setMinValue(0);
        np.setMaxValue(100);
        np.setWrapSelectorWheel(true);

        np1.setMinValue(0);
        np1.setMaxValue(100);
        np1.setWrapSelectorWheel(true);
        //   tvPonovitve = (TextView)findViewById(R.id.textViewPonovitve);
    //    tvSerije= (TextView) findViewById(R.id.textViewSerije);
        tv.setText(flj);
    }


}
