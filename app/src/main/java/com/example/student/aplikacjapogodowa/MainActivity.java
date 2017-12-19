package com.example.student.aplikacjapogodowa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText wpisz = findViewById(R.id.podaj);
        Button zmien = findViewById(R.id.zmien_miejsce);
        final TextView miasto = findViewById(R.id.NazwaMiasta);

        Button lista = findViewById(R.id.lista_miejsc);

        zmien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inne_miejsce = wpisz.getText().toString();
                miasto.setText(inne_miejsce);
            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AktywnoscMiejsca.class);
                startActivity(intent);
                Bundle bundle = new Bundle();bundle.putString("wpisz","miasto");
                intent.putExtras(bundle);
            }
        });

    }
}