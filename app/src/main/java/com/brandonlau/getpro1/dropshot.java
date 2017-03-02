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

public class dropshot extends Activity {
    trainingdb myDB3; //call trainingdb class
    /*
    * t1 = target for drop shot
    * dsr = drop shot to right
    * dsl = drop shot to left
    * cdr = cross drop shot to right
    * cdl = cross drop shot to left
    */
    private EditText t1, dsr, dsl, cdr, cdl;

    /*
    * tst1 = target set to
    * dsra = drop shot to right achieve
    * dsla = drop shot to left achieve
    * cdra = cross drop shot to right
    * cdrla = cross drop shot to left*/
    private TextView tst1, dsra, dsla, cdra, cdla;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dropshot);
        myDB3 = new trainingdb(this);
        submit = (Button) findViewById(R.id.submit_button1);
        submit3();

    }

    //buttons function in drop shot page
    public void onClickButton(View v) {
        //back button
        if (v.getId() == R.id.back_button) {
            Intent i = new Intent(dropshot.this, training.class);
            startActivity(i);
        }

        //set button
        else if(v.getId() == R.id.set_button1){
            //when set button is press it will get the value that user input
            t1 = (EditText) findViewById(R.id.target1);
            tst1 = (TextView) findViewById(R.id.targetsettotxt1);
            //display target value that user input
            tst1.setText(t1.getText());

        }

    }

    //submit button function
    public void submit3(){
        submit.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //when the submit button is press the value will be display at the bottom of the page
                        //at the same time the value will be added to database table
                        dsr = (EditText) findViewById(R.id.dropright);
                        dsra = (TextView) findViewById(R.id.straightdropshotrightachievetxt);
                        dsra.setText(dsr.getText());

                        dsl = (EditText) findViewById(R.id.dropleft);
                        dsla = (TextView) findViewById(R.id.straightdropshotleftachievetxt);
                        dsla.setText(dsl.getText());

                        cdr = (EditText) findViewById(R.id.crossdropright);
                        cdra = (TextView) findViewById(R.id.crossdropshotrightachievetxt);
                        cdra.setText(cdr.getText());

                        cdl = (EditText) findViewById(R.id.crossdropleft);
                        cdla = (TextView) findViewById(R.id.crossdropshotleftachievetxt);
                        cdla.setText(cdl.getText());

                        //value add to database
                        myDB3.insert3(dsr.getText().toString(), dsl.getText().toString(),
                                cdr.getText().toString(), cdl.getText().toString());
                    }
                }
        );
    }

}
