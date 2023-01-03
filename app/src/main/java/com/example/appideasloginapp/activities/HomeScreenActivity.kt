package com.example.appideasloginapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appideasloginapp.R
import com.example.appideasloginapp.adapters.UserListAdapter
import com.example.appideasloginapp.databinding.ActivityHomeScreenBinding
import com.example.appideasloginapp.models.UserListModel
import com.example.appideasloginapp.viewmodels.HomeScreenViewModel
import com.example.appideasloginapp.viewmodels.LoginViewModel

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var bindingHomeScreenActivity: ActivityHomeScreenBinding

    private var listOfUsers: ArrayList<UserListModel.Data> = ArrayList()

    private lateinit var userListAdapter: UserListAdapter

    private lateinit var homeScreenViewModel: HomeScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingHomeScreenActivity = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(bindingHomeScreenActivity.root)

        homeScreenViewModel = ViewModelProvider(this,defaultViewModelProviderFactory).get(HomeScreenViewModel::class.java)

        homeScreenViewModel.getUserList(this)

        bindingHomeScreenActivity.recyclerViewUserDetails.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        homeScreenViewModel.listOfUsers.observe(this){
            listOfUsers.addAll(it)
            userListAdapter.notifyDataSetChanged()

            Log.d("", "onCreate: ")
        }


        userListAdapter = UserListAdapter(this,listOfUsers)

        bindingHomeScreenActivity.recyclerViewUserDetails.adapter = userListAdapter
    }
}