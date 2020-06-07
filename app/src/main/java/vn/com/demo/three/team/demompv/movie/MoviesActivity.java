package vn.com.demo.three.team.demompv.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.datarepository.data.remote.RemoteDataManager;
import com.datarepository.model.Movie;

import java.util.List;

import vn.com.demo.three.team.demompv.R;
import vn.com.demo.three.team.demompv.baze.OnItemRecyclerClickListener;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.IMoviesView, OnItemRecyclerClickListener {

    private RecyclerView mMoviesRecyclerView;
    private ProgressBar mIndicatorProgressBar;

    private MoviesAdapter mMoviesAdapter;
    private MoviesPresenter mPresenter;

    private final String TAG = MoviesActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mMoviesRecyclerView = (RecyclerView) findViewById(R.id.movies_recyclerView);
        mIndicatorProgressBar = (ProgressBar) findViewById(R.id.movies_progressBar);

        // init Adapter
        mMoviesAdapter = new MoviesAdapter(this);
        mMoviesAdapter.setmMovieOnItemRecyclerClickListener(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mMoviesRecyclerView.setLayoutManager(layoutManager);
        mMoviesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mMoviesRecyclerView.setAdapter(mMoviesAdapter);

        // init Presenter
        mPresenter = new MoviesPresenter(this, this, new RemoteDataManager());
        mPresenter.loadData();
    }

    @Override
    public void showMovies(List<Movie> listMovies) {
        if (listMovies != null) {
            mMoviesAdapter.updateData(listMovies);
        }
    }

    @Override
    public void navigateMovieDetail(Movie movie) {
        Toast.makeText(this, "Navigate new Activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgresBar() {
        mIndicatorProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgresBar() {
        mIndicatorProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mPresenter.destroyView();
        super.onDestroy();
    }

    @Override
    public void onItemClickListener(Object o) {
        Toast.makeText(this, "Navigate new Activity", Toast.LENGTH_SHORT).show();
    }
}
