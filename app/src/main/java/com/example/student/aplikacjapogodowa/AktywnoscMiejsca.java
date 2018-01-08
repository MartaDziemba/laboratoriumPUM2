package com.example.student.aplikacjapogodowa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AktywnoscMiejsca extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.niedostepny)
    TextView wynik;
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc_miejsca);
        ButterKnife.bind(this);

        Bundle dane = getIntent().getExtras();
        String tekstDoWpisania = dane.getString("KEY");
        wynik.setText(tekstDoWpisania);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Miasteczko Slaskie", "Piekne miasto."));
        places.add(new Place("Naklo Slaskie","Calkiem fajne miasto."));
        places.add(new Place("Kranjska Gora","Najpiekniejsze miejsce na ziemi."));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        PlaceAdapter placeAdapter = new PlaceAdapter(places);
        recyclerView.setAdapter(placeAdapter);
    }


}
