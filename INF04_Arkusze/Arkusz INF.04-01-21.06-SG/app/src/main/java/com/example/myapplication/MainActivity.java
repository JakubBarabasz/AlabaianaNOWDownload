package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /***********************************

     * nazwa funkcji: Sumbit

     * parametry wejściowe:
     * view - View, widok pierwszego naszego widoku aplikacji


     * wartość zwracana:
     * emailString - String, wpisana wartość pola EditText email
     * passwordString - String, wpisana wartość pola EditText password
     * passwordConfirmString - String, wpisana wartość pola EditText passwordConfirm

     * autor: 0000000000000

     **********************************/
    public void Submit(View view){

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText passwordConfirm = findViewById(R.id.passwordConfirm);

        TextView communicates = findViewById(R.id.communicates);

        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();
        String passwordConfirmString = passwordConfirm.getText().toString();

        Pattern validEmailPattern = Pattern.compile("@");
        Matcher matcher = validEmailPattern.matcher(emailString);

        if(emailString.isEmpty() || passwordString.isEmpty() || passwordConfirmString.isEmpty()){
            communicates.setText("Wprowadź wszystkie dane");
        }
        else if(!passwordString.equals(passwordConfirmString)){
            communicates.setText("Hasła się róźnią");
        }
        else if (!matcher.find()){
            communicates.setText("Niepoprawny adres e-mail");
        }
        else {
            communicates.setText("Witaj " + emailString);
        }
    }
}