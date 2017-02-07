package vn.com.fsoft.three.team.demompv.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IApiClient {

    // Login
    @FormUrlEncoded
    @POST("user/login")
    Call<ResponseBody> login(@Field("username") String userId, @Field("password") String password, @Field("rememberMe") boolean rememberMe);

    // Register
    @FormUrlEncoded
    @POST("user")
    Call<ResponseBody> register(@Field("username") String username, @Field("email") String email);

    // Update Password
    @FormUrlEncoded
    @POST("user/{userId}/password")
    Call<ResponseBody> changePassword(@Path("userId") String userId, @Field("oldPassword") String oldPassword, @Field("newPassword") String newPassword);

    // Get User details
    @GET("user/{userId}")
    Call<ResponseBody> getUser(@Path("userId") String userId);

    // Join Meeting Room
    @FormUrlEncoded
    @POST("room/join")
    Call<ResponseBody> joinMeetingRoom(@Field("userId") String userId, @Field("roomKey") String roomKey);
}
