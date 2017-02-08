package vn.com.fsoft.three.team.demompv.network;

import com.google.gson.JsonObject;
import com.honda.messenger.network.listener.ApiClientCallback;
import com.honda.messenger.ui.model.user.AuthenticationType;
import com.honda.messenger.ui.model.user.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final ApiClient INSTANCE = new ApiClient();

    private static final Retrofit restAdapter = new Retrofit.Builder()
            .baseUrl("http://10.88.96.36:8080/ty00/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static final IApiClient service = restAdapter.create(IApiClient.class);

    public void login(String userId, String password, final ApiClientCallback<Boolean> callback) {
        JsonObject params = new JsonObject();
        params.addProperty("username", userId);
        params.addProperty("password", password);

        Call<ResponseBody> call = service.login(params);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // TODO: handle response to check if login is successful or failure
                if (response.isSuccessful()) {
                    if (callback != null) {
                        callback.onSuccess(Boolean.TRUE);
                    }
                } else {
                    if (callback != null) {
                        callback.onSuccess(Boolean.FALSE);
                    }
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

    public void joinMeetingRoom(String userId, String roomKey, final ApiClientCallback<Boolean> callback) {
        JsonObject params = new JsonObject();
        params.addProperty("username", userId);
        params.addProperty("roomKey", roomKey);
        Call<ResponseBody> call = service.joinMeetingRoom(params);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // TODO: handle response to check if join is successful or failure
                if (response.isSuccessful()) {
                    if (callback != null) {
                        callback.onSuccess(Boolean.TRUE);
                    }
                } else {
                    if (callback != null) {
                        callback.onSuccess(Boolean.FALSE);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (callback != null) {
                    callback.onFailure(t);
                }
            }
        });
    }

    public void register(String name, String userId, String password, final ApiClientCallback<Boolean> callback) {
        AuthenticationType authenticationType = new AuthenticationType();
        authenticationType.setKey("PASS_AUTH");
        authenticationType.setValue(password);

        JsonObject params = new JsonObject();
        params.addProperty("username", userId);
        params.addProperty("firstName", name);
        params.addProperty("authenticationType", String.valueOf(authenticationType));

        Call<ResponseBody> call = service.register(params);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // TODO: handle response to check if login is successful or failure
                if (response.isSuccessful()) {
                    if (callback != null) {
                        callback.onSuccess(Boolean.TRUE);
                    }
                } else {
                    if (callback != null) {
                        callback.onSuccess(Boolean.FALSE);
                    }
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

    public void getUserProfile(final String accessToken, final ApiClientCallback<User> callback) {
        Call<User> call = service.getUserProfile(accessToken);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body();
                    // TODO: handle response to check if getUserProfile is successful or failure
                    callback.onSuccess(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public void getUserDetail(final String userId, final String accessToken, final ApiClientCallback<User> callback) {
        Call<User> call = service.getUserDetail(userId, accessToken);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body();
                    // TODO: handle response to check if getUserProfile is successful or failure
                    callback.onSuccess(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public void changePassword(String userId, String oldPassword, String newPassword, final ApiClientCallback<Boolean> callback) {
        JsonObject params = new JsonObject();
        params.addProperty("oldPassword", oldPassword);
        params.addProperty("newPassword", newPassword);
        Call<ResponseBody> call = service.changePassword(userId, params);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // TODO: handle response to check if join is successful or failure
                if (response.isSuccessful()) {
                    if (callback != null) {
                        callback.onSuccess(Boolean.TRUE);
                    }
                } else {
                    if (callback != null) {
                        callback.onSuccess(Boolean.FALSE);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (callback != null) {
                    callback.onFailure(t);
                }
            }
        });
    }
}
