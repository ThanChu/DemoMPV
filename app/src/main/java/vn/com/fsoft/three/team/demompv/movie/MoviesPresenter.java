package vn.com.fsoft.three.team.demompv.movie;

import android.content.Context;

import com.datarepository.data.DataCallback;
import com.datarepository.data.remote.RemoteDataManager;
import com.datarepository.model.Movie;

import java.util.List;

/**
 * Created by ThanCV on 12/21/2016.
 */

public class MoviesPresenter implements MoviesContract.IMoviesPresenter {

    private MoviesContract.IMoviesView mMoviesView;
    private RemoteDataManager mRemoteDataManager;
    private Context mContext;

    public MoviesPresenter(Context context, MoviesContract.IMoviesView mMoviesView, RemoteDataManager mRemoteDataManager) {
        this.mContext = context.getApplicationContext();
        this.mRemoteDataManager = mRemoteDataManager;
        this.mMoviesView = mMoviesView;
    }

    @Override
    public void loadData() {
        mMoviesView.showProgresBar();
        mRemoteDataManager.getMovies(new DataCallback<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> movies) {
                if (null != mMoviesView) {
                    mMoviesView.hideProgresBar();
                    mMoviesView.showMovies(movies);
                }
            }

            @Override
            public void onError() {
                if (null != mMoviesView) {
                    mMoviesView.hideProgresBar();
                    mMoviesView.showErrorMessage("Error movie");
                }
            }
        });
    }

    @Override
    public void destroyView() {
        if (mMoviesView != null) {
            mMoviesView = null;
        }
    }
}
