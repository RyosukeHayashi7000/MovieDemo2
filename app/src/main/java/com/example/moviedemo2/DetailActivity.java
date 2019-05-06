package com.example.moviedemo2;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.moviedemo2.adapter.MovieDetailAdapter;
import com.example.moviedemo2.databinding.DetailActivityBinding;
import com.example.moviedemo2.model.Movie;

public class DetailActivity extends AppCompatActivity {

    public static final String MOVIE_ID = "movie_id";
    private Movie movie;
    //private RecyclerView recyclerView;
    private MovieDetailAdapter movieDetailAdapter;
    private DetailActivityBinding binding;

    public static void createIntent(Context context, Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("extra 'movie' must not be null");
        }

        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(MOVIE_ID,movie);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        binding = DataBindingUtil.setContentView(this, R.layout.detail_activity);

        Intent intent = getIntent();
        if (intent.hasExtra(MOVIE_ID)){
            movie = getIntent().getParcelableExtra(MOVIE_ID);

            //recyclerView = (RecyclerView) findViewById(R.id.rvdMovie);
            movieDetailAdapter = new MovieDetailAdapter(movie);

            LinearLayoutManager llm = new LinearLayoutManager(this);

            binding.rvdMovie.setHasFixedSize(true);

            binding.rvdMovie.setLayoutManager(llm);

            binding.rvdMovie.setAdapter(movieDetailAdapter);

//            TextView textView = (TextView)findViewById(R.id.tvTitle2);
//            textView.setText(movie.getTitle());
        }


    }
}
