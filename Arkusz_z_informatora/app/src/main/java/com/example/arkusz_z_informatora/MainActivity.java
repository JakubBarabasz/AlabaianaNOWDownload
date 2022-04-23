package com.example.arkusz_z_informatora;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = findViewById(R.id.layout);
        Button nextButton = findViewById(R.id.nextButton);
        Button prevButton = findViewById(R.id.prevButton);
        Switch aSwitch = findViewById(R.id.switch1);
        ImageView imageView = findViewById(R.id.imageView);
        EditText choice = findViewById(R.id.editTextNumberDecimal);
        int imageNumber;

        nextButton.setOnClickListener(view -> {

            imageView.setImageResource(R.drawable.img2);

        });

        prevButton.setOnClickListener(view -> {
            imageView.setImageResource(R.drawable.img2);
        });

        if(aSwitch.isChecked()){
           layout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
        }else{
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        }


    }






}