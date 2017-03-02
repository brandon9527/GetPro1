package com.brandonlau.getpro1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //all button function on main page
    public void onClickButton(View v){
        //when training button is press it will go to training page
        if(v.getId() == R.id.button_training) {
            Intent i = new Intent(MainActivity.this, training.class);
            startActivity(i);
        }

        //when history button is press it will go to history page
        else if(v.getId() == R.id.button_history){
            Intent i = new Intent(MainActivity.this, history.class);
            startActivity(i);
        }

        //when setting button is press it will go to setting page
        else if(v.getId() == R.id.button_setting){
            Intent i = new Intent(MainActivity.this, setting.class);
            startActivity(i);
        }

        //when about button is press it will go to about page
        else if(v.getId() == R.id.button_about) {
            Intent i = new Intent(MainActivity.this, about.class);
            startActivity(i);
        }

    }

}
