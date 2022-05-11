package com.example.snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button button;
    CoordinatorLayout layout;
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        layout = findViewById(R.id.layout);
        timePicker = findViewById(R.id.timePicker);

        button.setOnClickListener(v -> {
            // Create a snackbar
            int minute = timePicker.getMinute();
            String minuteString = String.valueOf(minute);
            int hour = timePicker.getHour();

            if (minute < 10) {
                minuteString = 0 + "" + minute;
            }


            String time = hour + ":" + minuteString;


            Snackbar snackbar = Snackbar.make(layout, time, Snackbar.LENGTH_LONG);

            snackbar.setAction(
                    "Delete", view -> Toast.makeText(MainActivity.this, "SnackBar Deleted", Toast.LENGTH_SHORT).show());
                    snackbar.show();
                });

    }
}