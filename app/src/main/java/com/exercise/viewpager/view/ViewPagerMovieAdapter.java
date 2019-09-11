package com.exercise.viewpager.view;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.exercise.viewpager.R;

public class ViewPagerMovieAdapter extends FragmentPagerAdapter {

    private int posInList;
    private Context context;
    private String[] tittles;
    private String[] actors;
    private String[] releasesDates;
    private String[] categories;
    private String[] movieImages;
    private String[] descriptions;
    private String[] mainActors;
    private String[] biographies;
    private String[] mainActorsImages;

    public ViewPagerMovieAdapter(int posInList, Context context,@NonNull FragmentManager fm, int behavior) {
        super(fm);
        this.posInList = posInList;
        this.context = context;
        tittles = this.context.getResources().getStringArray(R.array.moviesTittles);
        actors = this.context.getResources().getStringArray(R.array.moviesTittles);
        releasesDates = this.context.getResources().getStringArray(R.array.moviesTittles);
        categories = this.context.getResources().getStringArray(R.array.moviesTittles);
        movieImages = this.context.getResources().getStringArray(R.array.moviesImages);
        descriptions = this.context.getResources().getStringArray(R.array.moviesDescriptions);
        mainActors = this.context.getResources().getStringArray(R.array.moviesTittles);
        biographies = this.context.getResources().getStringArray(R.array.moviesTittles);
        mainActorsImages = this.context.getResources().getStringArray(R.array.moviesImages);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ActorsFragment.newInstance(tittles[posInList],actors[posInList],releasesDates[posInList],categories[posInList],movieImages[posInList]);
            case 1:
                return DetailsFragment.newInstance(descriptions[posInList]);
            case 2:
                return BiographyFragment.newInstance(mainActors[posInList],biographies[posInList],mainActorsImages[posInList]);
        }
        return ActorsFragment.newInstance(tittles[posInList],actors[posInList],releasesDates[posInList],categories[posInList],movieImages[posInList]);
    }

    @Override
    public int getCount() {
        return 0;
    }
}
