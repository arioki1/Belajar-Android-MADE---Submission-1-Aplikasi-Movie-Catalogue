package com.example.moviecatalogue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import static com.example.moviecatalogue.MainActivity.EXTRA_TITLE;

public class DetailFilmActivity extends AppCompatActivity {

    TextView tvTitile,tvRating,tvDesc;
    ImageView ivDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        Intent intent = getIntent();
        Film film = getIntent().getParcelableExtra(EXTRA_TITLE);


        tvTitile = (TextView) findViewById(R.id.title_detail);
        tvRating = (TextView) findViewById(R.id.tv_rating_detail);
        tvDesc = (TextView) findViewById(R.id.desc_detail);

        tvTitile.setText(film.getTitle());
        tvRating.setText(film.getRating());
        tvDesc.setText(film.getDescribtion());
        tvDesc.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

        ivDetail = (ImageView) findViewById(R.id.iv_detail);
        Glide.with(this).load(film.getFoto()).into(ivDetail);
    }
}
