package com.datarepository.data.remote;

import com.datarepository.data.DataCallback;
import com.datarepository.model.Movie;
import com.datarepository.model.MoviesResponse;
import com.datarepository.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ThangNTX on 12/1/2016.
 */

public class RemoteDataManager {

    private ApiInterface mApiInterface;

    public RemoteDataManager() {
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getMovies(final DataCallback<List<Movie>> dataCallback) {

        Call<MoviesResponse> call = mApiInterface.getMovies(Constant.API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> videos = response.body().getMovies();
                    dataCallback.onSuccess(videos);
                } else {
                    dataCallback.onError();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                dataCallback.onError();
            }
        });

    }

    public void getMovie(String id, final DataCallback<Movie> dataCallback) {
        Call<Movie> call = mApiInterface.getMovie(id);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Movie video = response.body();
                    dataCallback.onSuccess(video);
                } else {
                    dataCallback.onError();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                dataCallback.onError();
            }
        });
    }
}
