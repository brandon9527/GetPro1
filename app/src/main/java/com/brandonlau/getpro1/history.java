package com.brandonlau.getpro1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

public class history extends Activity {
    trainingdb myHistory; // call trainingdb class

    /*
    * c = clear shot button
    * d = drop shot button
    * n = net button
    * s = smash button
    */
    Button c, d, n, s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        myHistory = new trainingdb(this);
        c = (Button) findViewById(R.id.historyclear_button);
        d = (Button) findViewById(R.id.historydrop_button);
        n = (Button) findViewById(R.id.historynet_button);
        s = (Button) findViewById(R.id.historysmash_button);
        History();
        History2();
        History3();
        History4();
    }

    //back button function
    public void onClickButton(View v) {
        //when back button is press it will go back to main activity class
        if (v.getId() == R.id.back_button) {
            Intent i = new Intent(history.this, MainActivity.class);
            startActivity(i);
        }
    }

    //view clear shot history function
    public void History() {
        c.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor result = myHistory.his4();
                        if(result.getCount() != 0){
                            StringBuffer buff = new StringBuffer();
                            //data will be display with the format below while loop
                            while(result.moveToNext()){
                                buff.append("Attempts: " +result.getString(0)+ "\n");
                                buff.append("Clear shot to right: " +result.getString(1)+ "\n");
                                buff.append("Clear shot to left: " +result.getString(2)+ "\n");
                                buff.append("Cross clear to right: " +result.getString(3)+ "\n");
                                buff.append("Cross clear to left: " +result.getString(4)+ "\n\n");

                            }
                            //display all values in cursor with title of Clear shot training
                            display("Clear Shot Training ", buff.toString());
                        }
                        else{
                            //error will be display if there are no data in database
                            display("Error", "No data found");
                            return;
                        }

                    }
                }
        );

    }

    //view drop shot history function
    public void History2(){
        d.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Cursor result2 = myHistory.his3();
                        if(result2.getCount() != 0){
                            StringBuffer buff2 = new StringBuffer();
                            //data will be display with the format below while loop
                            while(result2.moveToNext()){
                                buff2.append("Attempts: " +result2.getString(0)+ "\n");
                                buff2.append("Drop to right: " +result2.getString(1)+ "\n");
                                buff2.append("Drop to left: " +result2.getString(2)+ "\n");
                                buff2.append("Cross drop to right: " +result2.getString(3)+ "\n");
                                buff2.append("Cross drop to left: " +result2.getString(4)+ "\n\n");
                            }
                            //display all values in cursor with title of Drop shot training
                            display("Drop shot Training ", buff2.toString());
                        }
                        else{
                            //error will be display if there are no data in database
                            display("Error", "No data found");
                            return;
                        }
                    }
                }
        );

    }

    //view net history function
    public void History3(){
        n.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Cursor result3 = myHistory.his2();
                        if( result3.getCount() != 0){
                            StringBuffer buff3 = new StringBuffer();
                            //data will be display with the format below while loop
                            while(result3.moveToNext()){
                                buff3.append("Attempts: " +result3.getString(0)+ "\n");
                                buff3.append("Net to right: "+result3.getString(1)+ "\n");
                                buff3.append("Net to left: "+result3.getString(2)+ "\n");
                                buff3.append("Cross net to right: "+result3.getString(3)+ "\n");
                                buff3.append("Cross net to left: "+result3.getString(4)+ "\n\n");

                            }
                            //display all values in cursor with title of Net training
                            display("Net Training ", buff3.toString());
                        }
                        else{
                            //error will be display if there are no data in database
                            display("Error", "No data found");
                            return;
                        }
                    }
                }
        );
    }

    //view smash history function
    public void History4(){
        s.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Cursor result4 = myHistory.his();
                        if(result4.getCount() != 0 ){
                            StringBuffer buff4 = new StringBuffer();
                            //data will be display with the format below while loop
                            while(result4.moveToNext()){
                                buff4.append("Attempts: " +result4.getString(0)+ "\n");
                                buff4.append("Half court smash: " +result4.getString(1)+ "\n");
                                buff4.append("Baseline smash: " +result4.getString(2)+ "\n\n");
                            }

                            //display all values in cursor with title of smash training
                            display("Smash Training", buff4.toString());
                        }

                        else{
                            //error will be display if there are no data in database
                            display("Error", "No data found");
                            return;
                        }

                    }
                }
        );
    }

    //function to view data in cursor
    public void display(String title, String message){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setCancelable(true);
        build.setTitle(title);
        build.setMessage(message);
        build.show();
    }
}
