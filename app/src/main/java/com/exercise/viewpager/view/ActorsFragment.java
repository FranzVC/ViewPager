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
        TextView tv_tittle, tv_actors, tv_releaseDate, tv_category;
        ImageView iv_movieImage;

        tv_tittle = root.findViewById(R.id.tittle);
        tv_actors = root.findViewById(R.id.actors);
        tv_releaseDate = root.findViewById(R.id.releaseDate);
        tv_category = root.findViewById(R.id.category);
        iv_movieImage = root.findViewById(R.id.iv_movieImage);

        tv_tittle.setText(getArguments().getString("tittle"));
        tv_actors.setText(getArguments().getString("actors"));
        tv_releaseDate.setText(getArguments().getString("releaseData"));
        tv_category.setText(getArguments().getString("category"));
        Picasso.get().load(getArguments().getString("movieImage")).resize(500,500).into(iv_movieImage);

        //getArguments().clear();
        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
