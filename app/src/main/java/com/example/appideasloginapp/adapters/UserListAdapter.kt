package com.example.appideasloginapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appideasloginapp.databinding.LayoutForUsersBinding
import com.example.appideasloginapp.models.UserListModel
import com.example.appideasloginapp.retrofit.RetrofitClient

class UserListAdapter(val mContext: Context, val usersList: ArrayList<UserListModel.Data>) : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val bindingLayoutForUsers = LayoutForUsersBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserListViewHolder(bindingLayoutForUsers)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {

        val currentUser = usersList[position]

        Glide.with(mContext)
            .load(RetrofitClient.BASE_URL+currentUser.photo)
            .into(holder.bindingLayoutForUsers.imageViewUserPhoto)

        holder.bindingLayoutForUsers.textViewUserEmail.text = currentUser.email
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    class UserListViewHolder(val bindingLayoutForUsers: LayoutForUsersBinding) : RecyclerView.ViewHolder(bindingLayoutForUsers.root)
}
