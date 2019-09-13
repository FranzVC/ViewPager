package com.exercise.viewpager.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.exercise.viewpager.R;

public class DetailsFragment extends Fragment {
    public static Fragment newInstance(String description) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle b = new Bundle();
        b.putString("description", description);
        detailsFragment.setArguments(b);

        return detailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_details, container, false);

        TextView description;

        description = root.findViewById(R.id.details);

        description.setText(getArguments().getString("description"));
        //getArguments().clear();

        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
