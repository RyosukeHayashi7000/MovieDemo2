package com.example.moviedemo2;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.example.moviedemo2.Infra.MovieDataService;
import com.example.moviedemo2.Infra.RetrofitInstance;
import com.example.moviedemo2.adapter.MovieAdapter;
import com.example.moviedemo2.databinding.ActivityMainBinding;
import com.example.moviedemo2.model.Movie;
import com.example.moviedemo2.model.MovieDBResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies;
    //private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private ActivityMainBinding binding;
    //private Listener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportActionBar().setTitle("TMBD NOW PLAYING MOVIES");

        getNowMovies();

        //listener = new Listener(this);


    }

    public void getNowMovies() {

        MovieDataService movieDataService = RetrofitInstance.getService();

        Call<MovieDBResponse> call = movieDataService.getPlayingMovies(this.getString(R.string.api_key));

        call.enqueue(new Callback<MovieDBResponse>() {
            @Override
            public void onResponse(Call<MovieDBResponse> call, Response<MovieDBResponse> response) {

                MovieDBResponse movieDBResponse = response.body();

                if (movieDBResponse != null && movieDBResponse.getMovies() != null) {

                    movies = (ArrayList<Movie>)movieDBResponse.getMovies();
                    
                    ShowOnRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<MovieDBResponse> call, Throwable t) {

            }
        });
    }

    private void test(Movie movie) {
        DetailActivity.createIntent(this, movie);
    }

    private void ShowOnRecyclerView() {

        //recyclerView = (RecyclerView) findViewById(R.id.rMovie);
        movieAdapter = new MovieAdapter(movies, new MovieAdapter.MovieClickListener() {
            @Override
            public void onClick(Movie movie) {
                test(movie);
            }
        });

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            binding.rMovie.setLayoutManager(new GridLayoutManager(this,2));
        }else{
            binding.rMovie.setLayoutManager((new GridLayoutManager(this,4)));
            binding.rMovie.setHasFixedSize(true);
        }

        binding.rMovie.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();

    }
}
