package com.exercise.viewpager.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.exercise.viewpager.R;
import com.exercise.viewpager.model.Movie;
import com.exercise.viewpager.view.MovieAdapter;

import java.io.Console;
import java.util.ArrayList;

public class MoviesListActivity extends AppCompatActivity {

    ArrayList<Movie> movies = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMovies = findViewById(R.id.rv_moviesList);
        loadMovies();
        MovieAdapter movieAdapter = new MovieAdapter(movies,this);

        rvMovies.setHasFixedSize(true);
        rvMovies.setAdapter(movieAdapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
    }

    public void loadMovies(){
        String[] tittles = getResources().getStringArray(R.array.moviesTittles);
        String[] descriptions = getResources().getStringArray(R.array.moviesDescriptions);
        String[] imagesURL = getResources().getStringArray(R.array.moviesImages);

        for (int i = 0;i<5;i++)
        {
            Movie movie = new Movie(tittles[i],descriptions[i],imagesURL[i]);
            movies.add(movie);
        }
        Log.d("STATE",movies.toString());
    }
}
