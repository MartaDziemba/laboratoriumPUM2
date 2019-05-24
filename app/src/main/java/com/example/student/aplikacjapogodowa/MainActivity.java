package com.example.student.aplikacjapogodowa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.podaj)
    EditText wpisz;

    @BindView(R.id.zmien_miejsce)
    Button zmien;

    @BindView(R.id.NazwaMiasta)
    TextView miasto;

    @BindView(R.id.lista_miejsc)
    Button lista;

    @BindView(R.id.obraz)
    ImageView obrazek;

    @OnClick(R.id.zmien_miejsce)
    void onClick_zmien(View view)
    {
        String inne_miejsce = wpisz.getText().toString();
        miasto.setText(inne_miejsce);

    }

    @OnClick(R.id.lista_miejsc)
    void onClick_lista(View view)
    {
        Intent intent = new Intent(MainActivity.this, AktywnoscMiejsca.class);
        Bundle bundle = new Bundle();
        String tekst = wpisz.getText().toString();
        bundle.putString("KEY",tekst);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent getData = getIntent();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String place = bundle.getString("Nazwa");
            miasto.setText(place);
        }
    }



}