package com.example.shadabhussain.popularmovies_stage2.utils;

/**
 * Created by shadabhussain on 7/10/2016.
 */
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class RxUtils {

    public static void unsubscribeIfNotNull(Subscription subscription) {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public static CompositeSubscription getNewCompositeSubIfUnsubscribed(CompositeSubscription subscription) {
        if (subscription == null || subscription.isUnsubscribed()) {
            return new CompositeSubscription();
        }

        return subscription;
    }
}

