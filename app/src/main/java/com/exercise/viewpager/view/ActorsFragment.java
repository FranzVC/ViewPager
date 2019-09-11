package com.exercise.viewpager.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.exercise.viewpager.R;
import com.squareup.picasso.Picasso;

public class ActorsFragment extends Fragment {


    public static Fragment newInstance(String tittle, String actors, String releaseDate, String category, String movieImage) {
        ActorsFragment actorsFragment = new ActorsFragment();
        Bundle b = new Bundle();
        b.putString("tittle", tittle);
        b.putString("actors", actors);
        b.putString("releaseData", releaseDate);
        b.putString("category", category);
        b.putString("movieImage", movieImage);
        actorsFragment.setArguments(b);
        return actorsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_actors, container, false);
        TextView tittle, actors, releaseDate, category;
        ImageView iv_movieImage;

        tittle = root.findViewById(R.id.tittle);
        actors = root.findViewById(R.id.actors);
        releaseDate = root.findViewById(R.id.releaseDate);
        category = root.findViewById(R.id.category);
        iv_movieImage = root.findViewById(R.id.iv_movieImage);

        tittle.setText(getArguments().getString("tittle"));
        actors.setText(getArguments().getString("actors"));
        releaseDate.setText(getArguments().getString("releaseData"));
        category.setText(getArguments().getString("category"));
        Picasso.get().load(getArguments().getString("movieImage")).resize(500,500).into(iv_movieImage);

        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
