package com.example.avnish.tictoc;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int arr[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //0->yellow,1->red
    //1,3
    int activeplayer = 0;

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
            if (activeplayer == 0) {
                txtvw.setText("YELLOW PLAYER");
                txtvw.setTextColor((Color.YELLOW));
                arr[imageId] = 1;
                img.setImageResource(R.drawable.yellow);
                img.animate().translationZBy(1000f).rotation(360).setDuration(2000);
                activeplayer = 1;

            } else {
                txtvw.setText("RED PLAYER");
                txtvw.setTextColor(Color.RED);
                arr[imageId] = 3;
                img.setImageResource(R.drawable.red);
                img.animate().translationZBy(1000f).rotation(360).setDuration(2000);
                activeplayer = 0;
            }
        }
        else{
            Toast.makeText(this,"AlREADY OCCUPIED AREA",Toast.LENGTH_SHORT).show();
        }

    }
}
