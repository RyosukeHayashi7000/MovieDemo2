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
    static final int RELEASEDATE = 3;
    static final int OVERVIEW = 4;
    static final int LANGUAGE = 5;

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
        }
        else if (position == 2){
            return RATE;
        }
        else if (position == 3){
            return RELEASEDATE;
        }else if (position == 4){
            return OVERVIEW;
        }else {
            return LANGUAGE;
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
            case RELEASEDATE: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_release_date, viewGroup, false);
                viewHolder = new MovieDetailViewHolder(view);

                return viewHolder;
            }
            case OVERVIEW: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_overview, viewGroup, false);
                viewHolder = new MovieDetailViewHolder(view);

                return viewHolder;
            }
            case LANGUAGE: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_language, viewGroup, false);
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
            movieDetailViewHolder.movieTitle.setText("Title: " + movie.getTitle());
        }else if (viewType == RATE){
            movieDetailViewHolder.movieRate.setText("Rate: " + Double.toString(movie.getVoteAverage()));
        }
        else if (viewType == RELEASEDATE){
        movieDetailViewHolder.movieReleaseDate.setText("Release date: " + movie.getReleaseDate());
        }
        else if (viewType == OVERVIEW){
        movieDetailViewHolder.movieOverView.setText("Overview: " + movie.getOverview());
        }
        else if (viewType == LANGUAGE){
            movieDetailViewHolder.movieLanguage.setText("Original language: " + movie.getOriginalLanguage());
        }
    }


    @Override
    public int getItemCount() {
        return 6;
    }

    public class MovieDetailViewHolder extends RecyclerView.ViewHolder {

       public TextView movieTitle;
       public TextView movieRate;
       public ImageView movieImage;
       public TextView movieReleaseDate;
       public TextView movieOverView;
       public TextView movieLanguage;

       public MovieDetailViewHolder(View itemView){
           super(itemView);

           movieImage = (ImageView) itemView.findViewById(R.id.ivMovie2);
           movieTitle = (TextView)itemView.findViewById(R.id.tvTitle2);
           movieRate = (TextView)itemView.findViewById(R.id.tvRate2);
           movieReleaseDate = (TextView)itemView.findViewById(R.id.tvReleaseDate);
           movieOverView = (TextView)itemView.findViewById(R.id.tvOverView);
           movieLanguage = (TextView)itemView.findViewById(R.id.tvLanguage);

       }


   }


}
