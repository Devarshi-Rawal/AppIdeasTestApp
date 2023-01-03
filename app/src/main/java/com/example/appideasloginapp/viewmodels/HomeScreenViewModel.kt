package com.example.appideasloginapp.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appideasloginapp.models.UserListModel
import com.example.appideasloginapp.retrofit.RetrofitClient
import com.example.appideasloginapp.retrofit.RetrofitInterfaces
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreenViewModel : ViewModel(){

    val isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val listOfUsers: MutableLiveData<ArrayList<UserListModel.Data>> = MutableLiveData<ArrayList<UserListModel.Data>>()

    fun getUserList(mContext: Context){

        isLoading.value = true

        val retrofitInterfaces: RetrofitInterfaces? = RetrofitClient.makeRetrofitClient()?.create(
            RetrofitInterfaces::class.java)

        if (retrofitInterfaces != null){

            val sharedPreference =  mContext.getSharedPreferences("CUSTOM_TOKEN",Context.MODE_PRIVATE)
            val customToken =sharedPreference.getString("customtoken","test")!!

            val callForUserList: Call<UserListModel> = retrofitInterfaces.getUsersList(customToken)

            Log.d("dddddToken", "getUserList: $customToken")

            callForUserList.enqueue(object : Callback<UserListModel>{
                override fun onResponse(
                    call: Call<UserListModel>,
                    response: Response<UserListModel>
                ) {

                    listOfUsers.value = response.body()?.data
                    Log.d("dddddlistOfUsers", "onResponse: ${listOfUsers.value?.size}")
                    isLoading.value = false
                }

                override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                    Log.d("dddddHsFailure", "onFailure: ",t)
                }

            })
        }
    }
}