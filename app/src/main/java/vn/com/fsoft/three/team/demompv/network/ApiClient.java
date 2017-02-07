package vn.com.fsoft.three.team.demompv.network;

import com.honda.messenger.network.listener.ApiClientCallback;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ApiClient {

    public static final ApiClient INSTANCE = new ApiClient();
    private static final Retrofit restAdapter = new Retrofit.Builder()
            .baseUrl("http://10.88.96.36:8080/ty00/api/")
            .build();

    private static final IApiClient service = restAdapter.create(IApiClient.class);

    public void login(String userId, String password, final ApiClientCallback<Boolean> callback) {
        Call<ResponseBody> call = service.login(userId, password , true);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // TODO: handle response to check if login is successful or failure
                if (callback != null) {
                    callback.onSuccess(Boolean.TRUE);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable error) {
                if (callback != null) {
                    callback.onFailure(error);
                }
            }
        });

    }

}
