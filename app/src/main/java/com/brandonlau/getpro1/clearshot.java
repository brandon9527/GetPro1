package com.brandonlau.getpro1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Brandon Lau on 2/13/2017.
 */

public class clearshot extends Activity {
    trainingdb myDB4; //call trainingdb class

    /*
    t = target,
    scr = Straight clear right,
    scl = Straight clear left,
    ccr = Cross clear right,
    ccl = Cross Clear left
    */
    private EditText t, scr, scl, ccr, ccl;

    /*
   tst = target set to,
   scra = Straight clear right achieve,
   scla = Straight clear left achieve,
   ccra = Cross clear right achieve,
   ccla = Cross Clear left achieve
   */
    private TextView tst, scra, scla, ccra, ccla;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clearshot);
        myDB4 = new trainingdb(this);
        submit = (Button) findViewById(R.id.submit_button);
        submit4();


    }

    //buttons function in clear shot page
    public void onClickButton(View v) {
        //back button
        if (v.getId() == R.id.back_button) {
            Intent i = new Intent(clearshot.this, training.class);
            startActivity(i);
        }

        //set button
        else if(v.getId() == R.id.set_button){
            //when set button is press it will get the value that user input
            t = (EditText) findViewById(R.id.target);
            tst = (TextView) findViewById(R.id.targetsettotxt);
            //display target value that user input
            tst.setText(t.getText());
        }

    }

    //submit button function in clear shot
    public void submit4(){
        submit.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //when the submit button is press the value will be display at the bottom of the page
                        //at the same time the value will be added to database table
                        scr = (EditText) findViewById(R.id.straightclearright);
                        scra = (TextView) findViewById(R.id.straightclearshotrightachievetxt);
                        scra.setText(scr.getText());

                        scl = (EditText) findViewById(R.id.straightclearleft);
                        scla = (TextView) findViewById(R.id.straightclearshotleftachievetxt);
                        scla.setText(scl.getText());

                        ccr = (EditText) findViewById(R.id.crossclearright);
                        ccra = (TextView) findViewById(R.id.crossclearshotrightachievetxt);
                        ccra.setText(ccr.getText());

                        ccl = (EditText) findViewById(R.id.crossclearleft);
                        ccla = (TextView) findViewById(R.id.crossclearshotleftachievetxt);
                        ccla.setText(ccl.getText());

                        //value add to database
                        myDB4.insert4(scr.getText().toString(), scl.getText().toString(),
                                ccr.getText().toString(), ccl.getText().toString());
                    }
                }
        );
    }

}