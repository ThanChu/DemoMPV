package vn.com.demo.three.team.demompv.network;

import com.google.gson.JsonObject;
import com.honda.messenger.ui.model.user.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IApiClient {

    // Login
    @Headers("Content-Type: application/json")
    @POST("user/login")
    Call<ResponseBody> login(@Body JsonObject body);

    // Register
    @Headers("Content-Type: application/json")
    @POST("user")
    Call<ResponseBody> register(@Body JsonObject body);

    // Update Password
    @Headers("Content-Type: application/json")
    @POST("user/{userId}/password")
    Call<ResponseBody> changePassword(@Path("userId") String userId, @Body JsonObject body);

    // Get User profile
    @GET("user/identity")
    Call<User> getUserProfile(@Query("access_token") String accessToken);

    // Get User details
    @GET("user/{userId}")
    Call<User> getUserDetail(@Path("userId") String userId, @Query("access_token") String accessToken);

    // Join Meeting Room
    @Headers("Content-Type: application/json")
    @POST("room/join")
    Call<ResponseBody> joinMeetingRoom(@Body JsonObject body);
}
