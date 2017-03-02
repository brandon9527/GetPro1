package com.brandonlau.getpro1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * Created by Brandon Lau on 2/13/2017.
 */

public class training extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training);

    }

    //all button function on training page
    public void onClickButton(View v){
        //back button
        if(v.getId() == R.id.back_button) {
            Intent i = new Intent(training.this, MainActivity.class);
            startActivity(i);
        }

        //clear shot training button
        else if(v.getId() == R.id.clearshottraining_button) {
            Intent i = new Intent(training.this, clearshot.class);
            startActivity(i); //when button is press it will go to clear shot page
        }

        //drop shot training button
        else if(v.getId() == R.id.dropshottraining_button) {
            Intent i = new Intent(training.this, dropshot.class);
            startActivity(i);//when button is press it will go to drop shot page
        }

        //net training button
        else if(v.getId() == R.id.nettraining_button) {
            Intent i = new Intent(training.this, net.class);
            startActivity(i);//when button is press it will go to net training page
        }

        //smash training button
        else if(v.getId() == R.id.smashtraining_button) {
            Intent i = new Intent(training.this, smash.class);
            startActivity(i);//when button is press it will go to smash training page
        }
    }
}
