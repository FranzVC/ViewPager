package com.exercise.viewpager.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exercise.viewpager.R;
import com.exercise.viewpager.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private ArrayList<Movie> movies;
    private Context context;

    public MovieAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View movieCard = inflater.inflate(R.layout.adapter_card, parent, false);
        return new MovieHolder(movieCard);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        Movie movie = movies.get(position);

        ImageView cardImage = holder.iv_movieLogo;
        TextView cardTittle = holder.tv_movieTittle;
        TextView cardDescription = holder.tv_movieDescription;

        Picasso.get()
                .load(movie.getImageURL())
                .resize(500,600)
                .into(cardImage);

        /*cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"clicked!",Toast.LENGTH_LONG).show();
            }
        });*/
        cardTittle.setText(movie.getTittle());
        cardDescription.setText(movie.getDescription());
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        private ImageView iv_movieLogo;
        private TextView tv_movieTittle,tv_movieDescription;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            iv_movieLogo = itemView.findViewById(R.id.iv_movieLogo);
            tv_movieTittle = itemView.findViewById(R.id.tv_movieTittle);
            tv_movieDescription = itemView.findViewById(R.id.tv_movieDescription);
        }
    }
}
