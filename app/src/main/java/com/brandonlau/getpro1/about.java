package com.brandonlau.getpro1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Brandon Lau on 2/13/2017.
 */

public class about extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }

    //back button function
    public void onClickButton(View v){
        if(v.getId() == R.id.back_button){
            Intent i = new Intent(about.this, MainActivity.class);
            startActivity(i);
        }
    }
}