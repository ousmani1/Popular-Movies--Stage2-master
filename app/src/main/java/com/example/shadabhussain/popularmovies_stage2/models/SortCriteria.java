package com.example.shadabhussain.popularmovies_stage2.models;

import java.io.Serializable;

/**
 * Created by shadabhussain on 7/10/2016.
 */
public enum SortCriteria implements Serializable {
    POPULARITY("popularity.desc"), RATING("vote_average.desc"), FAVORITES("favorites");
    public final String str;
    SortCriteria(String str) {
        this.str = str;
    }
    public int getId() {
        return this.str.hashCode();
    }
    public String toString() {
        return this.str;
    }

}
