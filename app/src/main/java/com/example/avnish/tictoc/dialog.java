package com.example.avnish.tictoc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class dialog extends Dialog {

    Button playagain;
    TextView wintxt;
    int i;

    public dialog(Context context, int i) {
        super(context, i);
        this.i=i;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        wintxt=findViewById(R.id.wintext);
        if(i==1){
            wintxt.setText("YELLOW PLAYER");
        }
        else  wintxt.setText("RED PLAYER");

        playagain=findViewById(R.id.playagain);
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



}
