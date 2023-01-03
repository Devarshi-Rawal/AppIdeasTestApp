package com.example.appideasloginapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{

        private var retrofit: Retrofit? = null
        const val BASE_URL: String = "https://chessmafia.com/php/Ardorcare/"

        fun makeRetrofitClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}