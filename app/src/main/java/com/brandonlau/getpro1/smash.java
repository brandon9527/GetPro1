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

public class smash extends Activity {
    trainingdb myDB; //call trainingdb class

    /*
    * t3 = target for smash
    * hs = half court smash
    * bls = baseline smash
    */
    private EditText t3, hs, bls;

    /*
    * tst3 = target set to for smash
    * hsa = half court smash achieve
    * blsa = baseline smash achieve
    */
    private TextView tst3, hsa, blsa;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smash);

        myDB = new trainingdb(this);

        submit = (Button) findViewById(R.id.submit_button3);
        submit();

    }


    //buttons function on smash page
    public void onClickButton(View v) {
        //set button
        if (v.getId() == R.id.back_button) {
            Intent i = new Intent(smash.this, training.class);
            startActivity(i);
        }

        //set button
        else if (v.getId() == R.id.set_button3) {
            //when set button is press it will get the value that user input
            t3 = (EditText) findViewById(R.id.target3);
            tst3 = (TextView) findViewById(R.id.targetsettotxt3);
            //display target value that user input
            tst3.setText(t3.getText());
        }

    }

    //submit button function on smash page
    public void submit() {
        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //when the submit button is press the value will be display at the bottom of the page
                        //at the same time the value will be added to database table
                        hs = (EditText) findViewById(R.id.smashhalf);
                        hsa = (TextView) findViewById(R.id.halfcourtsmashtachievetxt);
                        hsa.setText(hs.getText());

                        bls = (EditText) findViewById(R.id.smashbaseline);
                        blsa = (TextView) findViewById(R.id.baselinesmashachievetxt);
                        blsa.setText(bls.getText());

                        //value add to database
                        myDB.insert(hs.getText().toString(), bls.getText().toString());

                    }
                }
        );
    }
}



