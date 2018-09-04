package com.example.shadabhussain.popularmovies_stage2.services;

import android.content.Context;
import com.example.shadabhussain.popularmovies_stage2.api.MovieApi;
import com.example.shadabhussain.popularmovies_stage2.generators.ServiceGenerator;


/**
 * Created by shadabhussain on 7/10/2016.
 */
public class MovieService {
    MovieApi movieApi = null;

    public MovieService(Context context)
    {
        movieApi = ServiceGenerator.createService(MovieApi.class,context);
    }

    public void fetchMovies(String sortOrder, String apiKey)
    {
        movieApi.fetchMovies(sortOrder, apiKey);
    }

    public MovieApi getMovieApi() {
        return movieApi;
    }

}
