package com.example.moviedemo2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviedemo2.R;
import com.example.moviedemo2.model.Movie;

public class MovieDetailAdapter extends RecyclerView.Adapter<MovieDetailAdapter.MovieDetailViewHolder>{

    private Movie movie;

    static final int IMAGE = 0;
    static final int TITLE = 1;
    static final int RATE = 2;

    public MovieDetailAdapter (Movie movie) {

        this.movie = movie;

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return IMAGE;
        }
        else if (position == 1){
            return TITLE;
        }else {
            return RATE;
        }
    }
    @NonNull
    @Override
    public MovieDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = null;
        MovieDetailViewHolder viewHolder;

        switch (position) {
            case IMAGE: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image, viewGroup, false);
                viewHolder = new MovieDetailViewHolder(view);

                return viewHolder;
            }
            case TITLE: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_item, viewGroup, false);
                viewHolder = new MovieDetailViewHolder(view);

                return viewHolder;
            }
            case RATE: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rate, viewGroup, false);
                viewHolder = new MovieDetailViewHolder(view);

                return viewHolder;
            }
        }


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieDetailViewHolder movieDetailViewHolder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == IMAGE) {
            String imagePath = "https://image.tmdb.org/t/p/w500" + movie.getPosterPath();

                Glide.with(movieDetailViewHolder.movieImage.getContext())
                        .load(imagePath)
                        .into(movieDetailViewHolder.movieImage);

        }
        else if (viewType == TITLE) {
            movieDetailViewHolder.movieTitle.setText(movie.getTitle());
        }else if (viewType == RATE){
            movieDetailViewHolder.movieRate.setText(Double.toString(movie.getVoteAverage()));
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MovieDetailViewHolder extends RecyclerView.ViewHolder {

       public TextView movieTitle;
       public TextView movieRate;
       public ImageView movieImage;

       public MovieDetailViewHolder(View itemView){
           super(itemView);

           movieImage = (ImageView) itemView.findViewById(R.id.ivMovie2);
           movieTitle = (TextView)itemView.findViewById(R.id.tvTitle2);
           movieRate = (TextView)itemView.findViewById(R.id.tvRate2);
       }


   }


}
