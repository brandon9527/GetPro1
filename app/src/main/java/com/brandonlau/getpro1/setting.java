package com.brandonlau.getpro1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setting extends Activity {
    //clearh = clear history
    trainingdb clearh; //call trainingdb class
    Button clearhistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        clearh = new trainingdb(this);
        clearhistory = (Button) findViewById(R.id.clearhistory_button);
        ClearHistory();

    }

    //function for back button
    public void onClickButton(View v){
        if(v.getId() == R.id.back_button){
            Intent i = new Intent(setting.this, MainActivity.class);
            startActivity(i); // when back button is press it will go back main page
        }

    }

    //clear history function
    public void ClearHistory(){
        clearhistory.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //when clear history button is press it will perform delete all row in the table
                        clearh.Clear();
                    }
                }
        );
    }

}
