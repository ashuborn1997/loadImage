package com.example.lenovo.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {
    Bitmap bmp;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView)findViewById(R.id.imageView);
    }
    public void alivebuttonclicked(View v)
    {

        Toast.makeText(this,"Zinda hun main",Toast.LENGTH_SHORT).show();
    }




    public void loadimagebutton(View v)
    {

        loadImage();
    }
    private void loadImage()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bmp=BitmapFactory.decodeResource(getResources(),R.drawable.download);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(bmp);
                    }
                });
            }


        }).start();

    }
}
