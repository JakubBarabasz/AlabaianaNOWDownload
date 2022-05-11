package com.example.arkusz_z_informatora;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    int currentImage = 0;

    @SuppressLint({"RestrictedApi", "UseSwitchCompatOrMaterialCode"})
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

        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                layout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
            }
            else {
                layout.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            }
        });
        nextButton.setOnClickListener(view -> {
            currentImage++;
            if (currentImage > 3) {
                currentImage = 0;
            }

            if (currentImage == 0) {
                imageView.setImageResource(R.drawable.img1);
            }
            else if (currentImage == 1) {
                imageView.setImageResource(R.drawable.img2);
            }
            else if (currentImage == 2) {
                imageView.setImageResource(R.drawable.img3);
            }
            else if (currentImage == 3) {
                imageView.setImageResource(R.drawable.img4);
            }

        });

        prevButton.setOnClickListener(view -> {
            if (currentImage == -1) {
                currentImage = 3;
            }
            currentImage--;
            if (currentImage == 0) {
                imageView.setImageResource(R.drawable.img1);
            }
            else if (currentImage == 1) {
                imageView.setImageResource(R.drawable.img2);
            }
            else if (currentImage == 2) {
                imageView.setImageResource(R.drawable.img3);
            }
            else if (currentImage == 3) {
                imageView.setImageResource(R.drawable.img4);
            }

        });




    }






}