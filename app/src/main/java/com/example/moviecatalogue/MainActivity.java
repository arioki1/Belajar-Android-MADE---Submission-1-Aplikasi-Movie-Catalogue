package com.example.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvHome;
    private FilmAdapter filmAdapter;
    private ArrayList<Film> films= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHome = findViewById(R.id.lv_home);

        films.addAll(FilmData.getData());

        filmAdapter = new FilmAdapter(this);
        filmAdapter.setFilms(films);
        lvHome.setAdapter(filmAdapter);
    }
}
