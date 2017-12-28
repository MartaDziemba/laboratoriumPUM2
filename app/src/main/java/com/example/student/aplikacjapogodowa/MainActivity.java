package com.example.student.aplikacjapogodowa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.podaj)
    EditText wpisz;

    @BindView(R.id.zmien_miejsce)
    Button zmien;

    @BindView(R.id.NazwaMiasta)
    TextView miasto;

    @BindView(R.id.lista_miejsc)
    Button lista;
    @OnClick(R.id.zmien_miejsce)
    public void onClick_zmien(View view)
    {
        String inne_miejsce = wpisz.getText().toString();
        miasto.setText(inne_miejsce);

    }

    @OnClick(R.id.lista_miejsc)
    public void onClick_lista(View view)
    {
        Intent intent = new Intent(MainActivity.this, AktywnoscMiejsca.class);
        startActivity(intent);
        Bundle bundle = new Bundle();bundle.putString("wpisz","miasto");
        intent.putExtras(bundle);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Miasteczko Slaskie", 26));
        places.add(new Place("Naklo Slaskie",28));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        PlaceAdapter placeAdapter = new PlaceAdapter(places);
        recyclerView.setAdapter(placeAdapter);

    }
}