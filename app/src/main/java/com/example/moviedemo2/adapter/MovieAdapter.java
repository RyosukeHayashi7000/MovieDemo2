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

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    public interface MovieClickListener {
        void onClick(Movie movie);
    }

   // private Context context;
    private List<Movie> movieArrayList;
    private MovieClickListener listener;

    public MovieAdapter (ArrayList<Movie> movieArrayList, MovieClickListener listener) {

   //     this.context = context;
        this.movieArrayList = movieArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_items_list,viewGroup,false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int position) {
        movieViewHolder.movieTitle.setText(movieArrayList.get(position).getTitle());
        movieViewHolder.rate.setText(Double.toString(movieArrayList.get(position).getVoteAverage()));

        String imagePath = "https://image.tmdb.org/t/p/w500" + movieArrayList.get(position).getPosterPath();

        Glide.with(movieViewHolder.movieImage.getContext())
                .load(imagePath)
                .into(movieViewHolder.movieImage);

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    //1行分のデータ
    public class MovieViewHolder extends RecyclerView.ViewHolder{

        public TextView movieTitle, rate;
        public ImageView movieImage;

        public MovieViewHolder(View itemView){
            super(itemView);

            movieImage = (ImageView)itemView.findViewById(R.id.ivMovie);
            movieTitle = (TextView)itemView.findViewById(R.id.tvTitle);
            rate = (TextView)itemView.findViewById(R.id.tvRating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) ;

                    Movie selectedMovie = movieArrayList.get(position);
                    //DetailActivity.createIntent(context,selectedMovie);
                    listener.onClick(selectedMovie);

                }
            });
        }
    }


}
