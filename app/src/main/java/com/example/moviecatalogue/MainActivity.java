package com.example.moviecatalogue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvHome;
    private FilmAdapter filmAdapter;
    private ArrayList<Film> films= new ArrayList<>();

    public static final String EXTRA_TITLE = "titleFilm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHome = findViewById(R.id.lv_home);

        films.addAll(FilmData.getData());

        filmAdapter = new FilmAdapter(this);
        filmAdapter.setFilms(films);
        lvHome.setAdapter(filmAdapter);

        lvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(MainActivity.this, DetailFilmActivity.class);
                Film mFilm = films.get(position);

                Film film = new Film();
                film.setTitle(mFilm.getTitle());
                film.setFoto(mFilm.getFoto());
                film.setRating(mFilm.getRating());
                film.setDescribtion(mFilm.getDescribtion());


                mIntent.putExtra(EXTRA_TITLE, film);
                startActivity(mIntent);
            }
        });
    }
}
