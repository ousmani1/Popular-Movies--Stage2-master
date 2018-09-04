package com.example.shadabhussain.popularmovies_stage2.utils;

/**
 * Created by shadabhussain on 7/10/2016.
 */
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.shadabhussain.popularmovies_stage2.BuildConfig;
import com.example.shadabhussain.popularmovies_stage2.R;
import com.example.shadabhussain.popularmovies_stage2.models.Trailer;

public class TMDbUtils {
    private static final Uri TMDB_IMAGE_BASE_URI = Uri.parse("http://image.tmdb.org/t/p/");

    private interface TMDbImageWidth {
        String getWidthString();
        int getMaxWidth();
    }

    public enum TMDbPosterWidth implements TMDbImageWidth {
        W92(92), W154(154), W185(185), W342(342), W500(500), W780(780), ORIGINAL(Integer.MAX_VALUE);

        public final int maxWidth;
        TMDbPosterWidth(int maxWidth) {
            this.maxWidth = maxWidth;
        }
        public int getMaxWidth() {
            return this.maxWidth;
        }
        public String getWidthString() {
            return (this == ORIGINAL) ? "original" : "w" + this.maxWidth;
        }
    }

    public enum TMDbBackdropWidth implements TMDbImageWidth {
        W300(300), W780(780), W1280(1280), ORIGINAL(Integer.MAX_VALUE);

        public final int maxWidth;
        TMDbBackdropWidth(int maxWidth) {
            this.maxWidth = maxWidth;
        }
        public int getMaxWidth() {
            return this.maxWidth;
        }
        public String getWidthString() {
            return (this == ORIGINAL) ? "original" : "w" + this.maxWidth;
        }
    }

    public static String buildPosterUrl(String posterPath, int posterWidth) {
        return buildImageUrl(posterPath, computeNextLowestPosterWidth(posterWidth));
    }

    public static String buildBackdropUrl(String backdropPath, int backdropWidth) {
        return buildImageUrl(backdropPath, computeNextLowestBackdropWidth(backdropWidth));
    }

    private static <T extends TMDbImageWidth> String buildImageUrl(String imagePath, T tmdbImageWidth) {
        if (BuildConfig.DEBUG) {
//            Log.v("Picasso", "Loading image of width " + tmdbImageWidth.getMaxWidth() + "px");
        }
        String relativePath = tmdbImageWidth.getWidthString() + "/" + imagePath;
        return Uri.withAppendedPath(TMDB_IMAGE_BASE_URI, relativePath).toString();
    }


    // private methods

    // 50 => W92, 92 => W92, 93 => W185, 999 => ORIGINAL
    private static TMDbPosterWidth computeNextLowestPosterWidth(int posterWidth) {
        for (TMDbPosterWidth enumWidth : TMDbPosterWidth.values()) {
            if (0.8 * posterWidth <= enumWidth.maxWidth) {
                return enumWidth;
            }
        }
        return TMDbPosterWidth.ORIGINAL;
    }

    private static TMDbBackdropWidth computeNextLowestBackdropWidth(int backdropWidth) {
        for (TMDbBackdropWidth enumWidth : TMDbBackdropWidth.values()) {
            if (0.8 * backdropWidth <= enumWidth.maxWidth) {
                return enumWidth;
            }
        }
        return TMDbBackdropWidth.ORIGINAL;
    }
    public static String getUrl(Context context,@NonNull Trailer trailer) {
        if (trailer.getSite().equalsIgnoreCase(context.getResources().getString(R.string.trailer_source_youtube))) {
            return String.format("http://www.youtube.com/watch?v=%1$s", trailer.getKey());
        } else {
            throw new UnsupportedOperationException("Only YouTube is supported!");
        }
    }

    public static String getThumbnailUrl(Context context,@NonNull Trailer trailer) {
        if (trailer.getSite().equalsIgnoreCase(context.getResources().getString(R.string.trailer_source_youtube))) {
            Log.e("thumnail url is",""+String.format("http://img.youtube.com/vi/%1$s/0.jpg", trailer.getId()));
            return String.format("http://img.youtube.com/vi/%1$s/0.jpg", trailer.getKey());
        } else {
            throw new UnsupportedOperationException("Only YouTube is supported!");
        }
    }

}
