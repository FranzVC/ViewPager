package com.exercise.viewpager.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.exercise.viewpager.R;

public class MainActivity extends AppCompatActivity implements MovieListAdapter.OnClickItemListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.container, new MoviesListFragment(this))
                .commit();
    }

    @Override
    public void onMovieSelected(int index) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.container, new ViewPagerFragment(index))
                .addToBackStack(null)
                .commit();
    }
}
