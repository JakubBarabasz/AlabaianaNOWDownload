package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;


    @SuppressLint("ResourceType")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.animation);

        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
      }


    @SuppressLint("ResourceType")
    public void Start(View view){
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.startAnimation(
                AnimationUtils.loadAnimation(MainActivity.this, R.drawable.rotate) );
    }

    @SuppressLint("ResourceType")
    public void Stop(View view){
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.startAnimation(
                AnimationUtils.loadAnimation(MainActivity.this, R.drawable.stoprotate) );
    }
}