package com.example.appideasloginapp.retrofit

import com.example.appideasloginapp.models.LoginModel
import com.example.appideasloginapp.models.RegisterModel
import com.example.appideasloginapp.models.UserListModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitInterfaces {

    @FormUrlEncoded
    @POST("api/register")
    fun registerUser(
        @Field("role") role: Int,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("fcm_token") fcmToken: String
    ) : Call<RegisterModel>

    @FormUrlEncoded
    @POST("api/login")
    fun loginUser(
        @Field("username") userName: String,
        @Field("password") password: String,
        @Field("fcm_token") fcmToken: String
    ) : Call<LoginModel>

    @POST("api/get-user-list")
    fun getUsersList(
        @Header("custom-token") customToken: String
    ) : Call<UserListModel>
}