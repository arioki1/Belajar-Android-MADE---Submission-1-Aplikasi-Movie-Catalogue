package com.example.moviecatalogue;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
private Context context;
private ArrayList<Film> films;

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Film film = (Film) getItem(position);
        viewHolder.bind(film);

        return convertView;
    }

    private class ViewHolder{
        private TextView title;
        private TextView rating;
        private TextView description;
        private ImageView foto;

        public ViewHolder(View view) {
            this.title = view.findViewById(R.id.tv_list_title_home);
            this.rating = view.findViewById(R.id.tv_list_rating_home);
            this.description = view.findViewById(R.id.tv_list_description_home);
            this.foto = view.findViewById(R.id.iv_list_home);
        }
        void bind(Film film){
            title.setText(film.getTitle());
            rating.setText("Rating : "+film.getRating());
            description.setText("   "+film.getDescribtion());
            Glide.with(context).load(film.getFoto()).into(foto);

        }
    }
}
