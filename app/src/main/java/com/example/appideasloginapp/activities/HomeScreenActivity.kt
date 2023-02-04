package com.example.appideasloginapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
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

    private val viewModel: HomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingHomeScreenActivity = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(bindingHomeScreenActivity.root)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        viewModel.getUserList(this)

        viewModel.listOfUsers.observe(this) {
            bindingHomeScreenActivity.recyclerViewUserDetails.adapter = UserListAdapter(this, it)
        }
    }
}