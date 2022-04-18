package com.example.cookieclicker;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    int liczbaKlikniec; //zmienna w której przechowujemy liczbę kliknięć o wartości początkowej zero

    //funkcja start
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button); //importowanie przycisku

        ImageView cookie = findViewById(R.id.cookie); //importowanie naszego obrazka

        GifImageView gifImageView = findViewById(R.id.win); //importowanie gifa

        gifImageView.setVisibility(GifImageView.INVISIBLE); //ukrycie gifa

        //funkcja podpięta do przycisku, która zostaje wywołana za każdym razem wciśniemy przycisk

        button.setOnClickListener(v -> {

            Random random = new Random();

            int redRandom = random.nextInt(255);    //losowanie pierwszej liczby z zakresu od 1 do 255

            int greenRandom = random.nextInt(255);  //losowanie drugiej liczby z zakresu od 1 do 255

            int blueRandom = random.nextInt(255);   //losowanie trzeciej liczby z zakresu od 1 do 255


            cookie.setBackgroundColor(Color.argb(255,redRandom,greenRandom,blueRandom));

            //importowanie naszego widoku tekstu
            TextView wynik = findViewById(R.id.wynik);

            //za każdym razem gdy wywołamy funkcję onClick czyli gdy naciśniemy przycisk
            //wartość liczbakliknięć zwiększy się o 1

            liczbaKlikniec += 1;

            //przekazujemy do naszego tekstu wartość zmiennej liczbakliknięć
            wynik.setText(String.valueOf(liczbaKlikniec));

            /*
            funkcja Toast wyświetlająca małą wiadomość w postaci dymku
            Parametry tej funkci to kolejno:
            kontekst,
            tekst który chcemy wyświetlić
            oraz czas
            */

            //Toast.makeText(getApplicationContext(), "Właśnie mnie nacisnąłeś!", Toast.LENGTH_SHORT).show();

            //instrukcję warunkowe, czyli kiedy na przykład:
            //kiedy liczbaklikniec będzie wynosić 15 kolor przycisku zmieni się na czerwony

            if(liczbaKlikniec == 15) {
                cookie.setBackgroundColor(Color.argb(255,255,0,0));
            }

            if (liczbaKlikniec >= 420) {
                gifImageView.setVisibility(GifImageView.INVISIBLE); //ukrycie gifa
            }
        });
    }

}