package com.example.shadabhussain.popularmovies_stage2.api;
import com.example.shadabhussain.popularmovies_stage2.models.MoviesResponse;
import com.example.shadabhussain.popularmovies_stage2.models.ReviewsResponse;
import com.example.shadabhussain.popularmovies_stage2.models.TrailersResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by shadabhussain on 7/10/2016.
 */
public interface MovieApi {
    @GET("/3/discover/movie")
    Observable<MoviesResponse> fetchMovies(@Query("sort_by") String sortOrder, @Query("api_key") String apiKey);

    @GET("/3/discover/movie")
    Observable<MoviesResponse> fetchMovies(@Query("sort_by") String sortOrder, @Query("api_key") String apiKey,@Query("page") int page);

    @GET("/3/movie/{id}/videos")
    Observable<TrailersResponse> fetchTrailers(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("/3/movie/{id}/reviews")
    Observable<ReviewsResponse> fetchReviews(@Path("id") int id, @Query("api_key") String apiKey);
}

