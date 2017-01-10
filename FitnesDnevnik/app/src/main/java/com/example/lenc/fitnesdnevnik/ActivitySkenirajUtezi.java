package com.example.lenc.fitnesdnevnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ActivitySkenirajUtezi extends AppCompatActivity implements View.OnClickListener {
    private Button scanBtn;
    private TextView contentTxt;
    private Button add;
    ApplicationMy app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skeniraj_utezi);
        scanBtn = (Button)findViewById(R.id.buttonSkenirajUtezi);
        contentTxt = (TextView)findViewById(R.id.textView6);
        add=(Button)findViewById(R.id.buttonDodajSkeniranUtezi);
        app= (ApplicationMy) getApplication();
        scanBtn.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.getId()==R.id.buttonSkenirajUtezi){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }
    public void btnDodajUteziSkenirane(View v){
        app.getAll().dodaj(new Utezi(contentTxt.getText().toString()));
        finish();
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            if(scanContent.equals("9780123456786")){
                contentTxt.setText("Triceps s palco");

            }
            else if(scanContent.equals("036000291452")){
                contentTxt.setText("Biceps s palco");
            }
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
