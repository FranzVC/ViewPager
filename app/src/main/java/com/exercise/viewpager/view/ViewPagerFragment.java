package com.exercise.viewpager.view;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.exercise.viewpager.R;

public class ViewPagerFragment extends Fragment {

    private int posInList;
    ViewPagerFragment(int index) {
        this.posInList = index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movies_view_pager, container, false);
        ViewPager viewPager = root.findViewById(R.id.viewPager);

        viewPager.setAdapter(new ViewPagerMovieAdapter(posInList,getContext(), getActivity().getSupportFragmentManager()));
        return root;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
