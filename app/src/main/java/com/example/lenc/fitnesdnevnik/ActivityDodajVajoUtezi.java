package com.example.lenc.fitnesdnevnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityDodajVajoUtezi extends AppCompatActivity {

    private Button btnDodaj;
    ApplicationMy app;
    private EditText txtVaja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_vajo_utezi);
        btnDodaj=(Button)findViewById(R.id.buttonDodajVadboUtezi);
        txtVaja = (EditText) findViewById(R.id.editTextVaja);
        app= (ApplicationMy) getApplication();
    }
    public void btnDodajOnClick(View v){
        app.getAll().dodaj(new Utezi(txtVaja.getText().toString()));
        finish();
    }

}
