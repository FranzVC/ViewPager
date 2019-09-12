package com.exercise.viewpager.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exercise.viewpager.R;
import com.exercise.viewpager.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieHolder>  {

    private ArrayList<Movie> movies;
    private OnClickItemListener onClickItemListener;
    private Context context;

    public MovieListAdapter(ArrayList<Movie> movies, Context context,OnClickItemListener listener) {
        this.movies = movies;
        this.context = context;
        this.onClickItemListener = listener;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View movieCard = inflater.inflate(R.layout.movie_item, parent, false);
        return new MovieHolder(movieCard,onClickItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, final int position) {

        Movie movie = movies.get(position);

        ImageView cardImage = holder.iv_movieLogo;
        TextView cardTittle = holder.tv_movieTittle;
        TextView cardDescription = holder.tv_movieDescription;

        Picasso.get()
                .load(movie.getImageURL())
                .resize(500,600)
                .into(cardImage);

        cardTittle.setText(movie.getTittle());
        cardDescription.setText(movie.getDescription());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView iv_movieLogo;
        private TextView tv_movieTittle, tv_movieDescription;
        private OnClickItemListener onClickItemListener;

        MovieHolder(@NonNull final View itemView, OnClickItemListener listener) {
            super(itemView);
            this.onClickItemListener = listener;
            iv_movieLogo = itemView.findViewById(R.id.iv_movieLogo);
            tv_movieTittle = itemView.findViewById(R.id.tv_movieTittle);
            tv_movieDescription = itemView.findViewById(R.id.tv_movieDescription);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show();
            onClickItemListener.onMovieSelected(getAdapterPosition());
        }
    }

    public interface OnClickItemListener {
        void onMovieSelected(int index);
    }
}
