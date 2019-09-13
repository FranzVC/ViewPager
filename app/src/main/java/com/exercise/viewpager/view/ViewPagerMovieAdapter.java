package com.exercise.viewpager.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.exercise.viewpager.R;

public class ViewPagerMovieAdapter extends FragmentPagerAdapter {
    private int posInList;
    private Context context;

    public ViewPagerMovieAdapter(int posInList, Context context,FragmentManager fm) {
        super(fm);
        this.posInList = posInList;
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        String[] tittles;
        String[] actors;
        String[] releasesDates;
        String[] categories;
        String[] movieImages;
        String[] descriptions;
        String[] mainActors;
        String[] biographies;
        String[] mainActorsImages;

        tittles = context.getResources().getStringArray(R.array.moviesTittles);
        actors = context.getResources().getStringArray(R.array.actors);
        releasesDates = context.getResources().getStringArray(R.array.releasesDates);
        categories = context.getResources().getStringArray(R.array.moviesTittles);
        movieImages = context.getResources().getStringArray(R.array.moviesImages);
        descriptions = context.getResources().getStringArray(R.array.moviesDescriptions);
        mainActors = context.getResources().getStringArray(R.array.mainActors);
        biographies = context.getResources().getStringArray(R.array.biographies);
        mainActorsImages = context.getResources().getStringArray(R.array.actorsImages);
        switch (position) {
            case 0:
                return ActorsFragment.newInstance(tittles[posInList],actors[posInList],releasesDates[posInList],categories[posInList],movieImages[posInList]);
            case 1:
                return DetailsFragment.newInstance(descriptions[posInList]);
            case 2:
                return BiographyFragment.newInstance(mainActorsImages[posInList],mainActors[posInList],biographies[posInList]);
        }
        return ActorsFragment.newInstance(tittles[posInList],actors[posInList],releasesDates[posInList],categories[posInList],movieImages[posInList]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
