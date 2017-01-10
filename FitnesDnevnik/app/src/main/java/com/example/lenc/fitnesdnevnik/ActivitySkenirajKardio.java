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

public class ActivitySkenirajKardio extends AppCompatActivity implements View.OnClickListener {

    private Button scanBttn;
    private TextView contentTxt;
    private Button dodaj;
    ApplicationMy app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skeniraj_kardio);
        scanBttn = (Button)findViewById(R.id.buttonSkenirajUtezi);
        contentTxt=(TextView)findViewById(R.id.textViewNaziv);
        dodaj=(Button)findViewById(R.id.buttonDodajPoSkeniranju);
        app= (ApplicationMy) getApplication();
        scanBttn.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.getId()==R.id.buttonSkenirajUtezi){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }
    public void btnDodajSkanOnClick(View v){
        app.getAll().dodaj(new Kardio(contentTxt.getText().toString()));
        finish();
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            if(scanContent.equals("850006000012")){
                contentTxt.setText("Hoja po stopnicah");
            }
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
