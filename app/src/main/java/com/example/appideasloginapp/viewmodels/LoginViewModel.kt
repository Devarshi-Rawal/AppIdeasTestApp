package com.example.appideasloginapp.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appideasloginapp.models.LoginModel
import com.example.appideasloginapp.retrofit.RetrofitClient
import com.example.appideasloginapp.retrofit.RetrofitInterfaces
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel(){

    val isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val message: MutableLiveData<String> = MutableLiveData<String>()
    val loginModelData: MutableLiveData<LoginModel.Data> = MutableLiveData<LoginModel.Data>()

    fun loginUser(mContext: Context,userName: String,pwd: String){

        isLoading.value = true

        val retrofitInterfaces: RetrofitInterfaces? = RetrofitClient.makeRetrofitClient()?.create(
            RetrofitInterfaces::class.java)

        if (retrofitInterfaces != null){

            val callLoginUser: Call<LoginModel> = retrofitInterfaces.loginUser(userName,pwd,"test")
            callLoginUser.enqueue(object : Callback<LoginModel>{
                override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                    Toast.makeText(mContext, response.message(), Toast.LENGTH_LONG).show()
                    message.value = response.body()?.message
                    loginModelData.value = response.body()?.data

                    val sharedPreference =  mContext.getSharedPreferences("CUSTOM_TOKEN",Context.MODE_PRIVATE)
                    val editor = sharedPreference.edit()
                    editor.putString("customtoken","${response.body()?.data?.customToken}")
                    editor.apply()


                    isLoading.value = false
                }

                override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                    Log.d("dddddLogError", "onFailure: ",t)
                }

            })
        }
    }
}