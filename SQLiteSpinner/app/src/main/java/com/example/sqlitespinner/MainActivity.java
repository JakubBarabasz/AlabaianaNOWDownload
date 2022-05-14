package com.example.sqlitespinner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import java.util.List;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Button btnAdd;
    EditText inputLabel;
    EditText inputTelephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        btnAdd =  findViewById(R.id.button);
        inputLabel = findViewById(R.id.plainText);
        inputTelephone = findViewById(R.id.plainText2);

        spinner.setOnItemSelectedListener(this);

        loadSpinnerData();

        btnAdd.setOnClickListener(arg0 -> {
            String label = inputLabel.getText().toString();
            String labelTelephone = inputTelephone.getText().toString();


            if (label.trim().length() > 0) {
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.insertLabel(label);

                inputLabel.setText("");
                inputTelephone.setText("");


                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(inputLabel.getWindowToken(), 0);
                loadSpinnerData();
            } else {
                Toast.makeText(getApplicationContext(), "Wprowadź nazwę", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadSpinnerData() {
        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        List<String> labels = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String label = parent.getItemAtPosition(position).toString();
        String text = spinner.getSelectedItem().toString();

        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        db.getTelephone(text);

        Toast.makeText(parent.getContext(), "Wybrano: " + text, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);

    }
}