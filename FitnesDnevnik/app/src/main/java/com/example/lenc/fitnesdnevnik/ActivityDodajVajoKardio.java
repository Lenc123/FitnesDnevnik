package com.example.lenc.fitnesdnevnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityDodajVajoKardio extends AppCompatActivity {

    private Button btnDodaj;
    private Button btnDodajSkeniraj;
    ApplicationMy app;
    private EditText txtVaja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_vajo_kardio);

        btnDodaj=(Button)findViewById(R.id.buttonDodajVadboKardio);
        btnDodajSkeniraj=(Button)findViewById(R.id.buttonSkenirajKardio);
        txtVaja = (EditText) findViewById(R.id.editTextVajaKardio);
        app= (ApplicationMy) getApplication();
    }
    public void btnDodajOnClick(View v){
        app.getAll().dodaj(new Kardio(txtVaja.getText().toString()));
        finish();
    }
    public void btnDodajSkenirajOnClick(View v){
        Intent skenirajKardio = new Intent(this,ActivitySkenirajKardio.class);
        startActivity(skenirajKardio);
    }
}
