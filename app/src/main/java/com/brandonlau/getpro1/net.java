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

public class net extends Activity {
    trainingdb myDB2; //call trainingdb class
    /*
    * t2 = target for net
    * nr = net to right
    * nl = net to left
    * cnr = cross net to right
    * cnl = cross net to left
    */
    private EditText t2, nr, nl, cnr, cnl;

    /*
    * tst2 = target set to for net
    * nra = net to right achieve
    * nla = net to left achieve
    * cnra = cross net to right achieve
    * cnla = cros net to left achieve
    */
    private TextView tst2, nra, nla, cnra, cnla;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net);
        myDB2 = new trainingdb(this);
        submit = (Button) findViewById(R.id.submit_button2);
        submit2();
    }

    //buttons function for net page
    public void onClickButton(View v) {
        //back button
        if (v.getId() == R.id.back_button) {
            Intent i = new Intent(net.this, training.class);
            startActivity(i);
        }

        //set button
        else if(v.getId() == R.id.set_button2){
            //when set button is press it will get the value that user input
            t2 = (EditText) findViewById(R.id.target2);
            tst2 = (TextView) findViewById(R.id.targetsettotxt2);
            //display target value that user input
            tst2.setText(t2.getText());
        }

    }

    //submit button on net page
    public void submit2(){
        submit.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //when the submit button is press the value will be display at the bottom of the page
                        //at the same time the value will be added to database table
                        nr = (EditText) findViewById(R.id.netright);
                        nra = (TextView) findViewById(R.id.netrightachievetxt);
                        nra.setText(nr.getText());

                        nl = (EditText) findViewById(R.id.netleft);
                        nla = (TextView) findViewById(R.id.netleftachievetxt);
                        nla.setText(nl.getText());

                        cnr = (EditText) findViewById(R.id.crossnetright);
                        cnra = (TextView) findViewById(R.id.crossnetrightachievetxt);
                        cnra.setText(nr.getText());

                        cnl = (EditText) findViewById(R.id.crossnetleft);
                        cnla = (TextView) findViewById(R.id.crossnetleftachievetxt);
                        cnla.setText(cnl.getText());

                        //value add to database
                        myDB2.insert2(nr.getText().toString(), nl.getText().toString(),
                                cnr.getText().toString(), cnl.getText().toString());
                    }
                }
        );
    }

}
