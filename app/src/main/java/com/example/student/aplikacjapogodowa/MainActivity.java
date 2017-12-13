package com.example.student.aplikacjapogodowa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText wpisz = findViewById(R.id.podaj);
        Button zmien = findViewById(R.id.zmien_miejsce);
        TextView miasto = findViewById(R.id.NazwaMiasta);

        Button lista = findViewById(R.id.lista_miejsc);
    }
}