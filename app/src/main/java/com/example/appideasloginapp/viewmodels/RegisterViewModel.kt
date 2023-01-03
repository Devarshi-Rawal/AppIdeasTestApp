package com.example.appideasloginapp.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appideasloginapp.models.RegisterModel
import com.example.appideasloginapp.retrofit.RetrofitClient
import com.example.appideasloginapp.retrofit.RetrofitInterfaces
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel(){

    val isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val status: MutableLiveData<String> = MutableLiveData<String>()

    fun registerUser(mContext: Context,email: String, pwd: String){

        isLoading.value = true

        val retrofitInterfaces: RetrofitInterfaces? = RetrofitClient.makeRetrofitClient()?.create(RetrofitInterfaces::class.java)
        if (retrofitInterfaces != null) {
            val callToRegister: Call<RegisterModel> =
                retrofitInterfaces.registerUser(1, email, pwd, "test")
            callToRegister.enqueue(object : Callback<RegisterModel>{
                override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>) {

                    status.value = response.body()?.status
                    Toast.makeText(mContext, response.message(),Toast.LENGTH_LONG).show()
                    isLoading.value = false
                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                    Toast.makeText(mContext, "Something went wrong!",Toast.LENGTH_LONG).show()
                    Log.d("dddddRegError", "onFailure: ",t)
                }

            })
        }
    }
}