package com.exercise.viewpager.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.exercise.viewpager.R;

public class BiographyFragment extends Fragment {

    public static Fragment newInstance(String mainActorImage, String mainActor, String biography) {
        BiographyFragment biographyFragment = new BiographyFragment();
        Bundle b = new Bundle();
        b.putString("mainActorImage",mainActorImage);
        b.putString("mainActor", mainActor);
        b.putString("biography", biography);
        biographyFragment.setArguments(b);

        return biographyFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_biography, container, false);


        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
