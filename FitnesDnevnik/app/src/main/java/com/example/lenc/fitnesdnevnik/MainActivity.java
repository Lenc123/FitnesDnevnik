package com.example.lenc.fitnesdnevnik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


//import com.google.android.gms.auth.api.Auth;
//import com.google.android.gms.common.SignInButton;

public class MainActivity extends AppCompatActivity {

    private Button buttonKardio;
    private Button buttonUtezi;
    private Button buttonUser;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonKardio=(Button)findViewById(R.id.buttonKardio);
        buttonUtezi=(Button)findViewById(R.id.buttonUtezi);
        buttonUser = (Button)findViewById(R.id.buttonUser);
        buttonUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentUSer = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intentUSer);
            }
        });
    }


    public void buttonKardioOnClick(View v){
        Intent intentKardio = new Intent(this,ActivityKardio.class);
        startActivity(intentKardio);
    }
    public void buttonUtezionClick(View v){
        Intent intentUtezi = new Intent(this,ActivityUtezi.class);
        startActivity(intentUtezi);
    }
    public void buttonUserOnClick(View v){

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
