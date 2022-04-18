package com.example.sqlite01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("Uczelnia", MODE_PRIVATE, null);
        String sqlDB = "CREATE TABLE IF NOT EXISTS STUDENCI (Id INTEGER, Imie VARCHAR, Nazwisko VARCHAR)";
        db.execSQL(sqlDB);

        String sqlCount = "SELECT COUNT(*) FROM STUDENCI";
        Cursor cursor = db.rawQuery(sqlCount, null);
        cursor.moveToFirst();
        int ilosc = cursor.getInt(0);
        cursor.close();
        if(ilosc == 0) {
            String sqlStudent = "INSERT INTO STUDENCI VALUES (? , ? , ?)";
            SQLiteStatement statement = db.compileStatement(sqlStudent);
            statement.bindLong(1, 1);
            statement.bindString(2, "Jan");
            statement.bindString(3, "Kowalski");
            statement.executeInsert();

            //statement.clearBindings();
            statement.bindLong(1, 2);
            statement.bindString(2, "Anna");
            statement.bindString(3, "Nowak");
            statement.executeInsert();

            statement.bindLong(1, 3);
            statement.bindString(2, "Piotr");
            statement.bindString(3, "Rutkowski");

            statement.executeInsert();
        }
    }



    public void OnClick(View view) {
        ArrayList<String> wyniki = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT Id, Imie, Nazwisko FROM STUDENCI;", null);
        if (c.moveToFirst()) {
            do {
                
                @SuppressLint("Range") int id = c.getInt(c.getColumnIndex("Id"));
                @SuppressLint("Range") String imie = c.getString(c.getColumnIndex("Imie"));
                @SuppressLint("Range") String nazwisko = c.getString(c.getColumnIndex("Nazwisko"));

                wyniki.add("Id: " + id + " Imie: " + imie + " Nazwisko: " + nazwisko);
            } while (c.moveToNext());
        }
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wyniki);
        listView.setAdapter(adapter);
        c.close();
    }
}