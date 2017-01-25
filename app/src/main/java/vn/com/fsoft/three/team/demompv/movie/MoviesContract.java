package vn.com.fsoft.three.team.demompv.movie;

import com.datarepository.model.Movie;

import java.util.List;

import vn.com.fsoft.three.team.demompv.baze.BasePresenter;
import vn.com.fsoft.three.team.demompv.baze.BaseView;

/**
 * Created by ThanCV on 12/21/2016.
 */

public interface MoviesContract {
    interface IMoviesView extends BaseView {
        void showMovies(List<Movie> listMovies);

        void navigateMovieDetail(Movie movie);
    }

    interface IMoviesPresenter extends BasePresenter {
    }
}
