package com.exercise.viewpager.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.exercise.viewpager.R;
import com.exercise.viewpager.model.Movie;

import java.util.ArrayList;

public class MoviesListFragment extends Fragment  {

    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieListAdapter.OnClickItemListener listener;

    MoviesListFragment(MovieListAdapter.OnClickItemListener listener){
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movies_list, container, false);

        RecyclerView rvMovies = root.findViewById(R.id.rv_moviesList);
        loadMovies();
        MovieListAdapter movieAdapter = new MovieListAdapter(movies, getContext(),listener);

        rvMovies.setHasFixedSize(true);
        rvMovies.setAdapter(movieAdapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void loadMovies() {
        String[] tittles = getResources().getStringArray(R.array.moviesTittles);
        String[] descriptions = getResources().getStringArray(R.array.moviesDescriptions);
        String[] imagesURL = getResources().getStringArray(R.array.moviesImages);

        for (int i = 0; i < 5; i++) {
            Movie movie = new Movie(tittles[i], descriptions[i], imagesURL[i]);
            movies.add(movie);
        }
    }



}
