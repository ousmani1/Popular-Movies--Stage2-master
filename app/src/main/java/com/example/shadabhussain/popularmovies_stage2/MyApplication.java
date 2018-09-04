package com.example.shadabhussain.popularmovies_stage2;

/**
 * Created by shadabhussain on 7/10/2016.
 */
import android.app.Application;

public class MyApplication extends Application {
    private MyApplication _instance;
    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
    }

    public MyApplication getInstance() {
        return _instance;
    }

    public void setInstance(MyApplication _instance) {
        this._instance = _instance;
    }
}

