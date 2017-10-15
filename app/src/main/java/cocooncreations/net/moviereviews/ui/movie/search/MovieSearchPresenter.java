package cocooncreations.net.moviereviews.ui.movie.search;

import android.util.Log;

import javax.inject.Inject;

import cocooncreations.net.moviereviews.data.DataManager;
import cocooncreations.net.moviereviews.ui.base.BasePresenter;
import rx.Subscription;

/**
 * Created by aleksandr on 10/14/17.
 */

public class MovieSearchPresenter extends BasePresenter<MovieSearchMvpView> {

    private final DataManager dataManager;
    private Subscription subscription;

    @Inject
    MovieSearchPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MovieSearchMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) subscription.unsubscribe();
    }

    void searchMovies(String query) {
        if (query != null && !query.isEmpty()) {
            dataManager.searchMovies(query);
        }
    }

    void loadSearchResults(String query) {
        dataManager.loadSearchResults(query)
                .subscribe(movies -> {
                    getMvpView().showSearchResults(movies);
                }, throwable -> {
                    Log.e(this.getClass().getSimpleName(), throwable.getMessage());
                });
    }
}
