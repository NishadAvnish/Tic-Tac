package com.example.avnish.tictoc;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int arr[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //0->yellow,1->red
    //1,3
    int activeplayer = 0;

    int gamecheck[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

    }

    public void getin(View view) {
        TextView txtvw=(TextView)findViewById(R.id.textview);
        ImageView img = (ImageView) view;
        int imageId = Integer.parseInt(img.getTag().toString());
        img.setTranslationZ(-1000f);

        //one can not click on pre occupied block using this IF()
        if(arr[imageId]==2) {

            //for yellow one
            if (activeplayer == 0) {
                txtvw.setText("YELLOW PLAYER");
                txtvw.setTextColor((Color.YELLOW));
                arr[imageId] = 1;
                img.setImageResource(R.drawable.yellow);
                img.animate().translationZBy(1000f).rotation(360).setDuration(2000);
                if(check()==true){
                    //yellow win
                    Toast.makeText(this,"Yellow player win",Toast.LENGTH_SHORT).show();
                    dialog1(MainActivity.this,1);


                }
                activeplayer = 1;

            }
            //for red player
            else {
                txtvw.setText("RED PLAYER");
                txtvw.setTextColor(Color.RED);
                arr[imageId] = 3;
                img.setImageResource(R.drawable.red);
                img.animate().translationZBy(1000f).rotation(360).setDuration(2000);
                if(check()==true){
                    //red win
                    Toast.makeText(this,"Red player win",Toast.LENGTH_SHORT).show();
                    dialog1(MainActivity.this,3);
                }
                activeplayer = 0;
            }
        }
        else{
            Toast.makeText(this,"AlREADY OCCUPIED AREA",Toast.LENGTH_SHORT).show();
        }

    }


    //to check is the player win or not

    Boolean check() {
        for(int[] check:gamecheck){
            if(activeplayer==0) {
                if (arr[check[0]] ==1 && arr[check[1]]==1 && arr[check[2]]==1) {
                   return true;
                }

            }

            else
            {
                if (arr[check[0]] ==3 && arr[check[1]]==3 && arr[check[2]]==3) {
                return true;
            }

            }
        }
     return false;
    }

    public void dialog1(Context c,int i) {
       dialog d=new dialog(c,i);
       d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       d.setCancelable(false);
       d.show();
    }
}
