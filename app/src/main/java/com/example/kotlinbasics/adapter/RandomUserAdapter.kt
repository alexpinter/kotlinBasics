package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinbasics.R
import com.example.kotlinbasics.model.RUser
import com.example.kotlinbasics.model.User

class RandomUserAdapter(private val userList: List<RUser>) :
    RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder>() {

    class RandomUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.profileImageRandomUser)
        val nameText: TextView = itemView.findViewById(R.id.nameTextRandomUser)
        val emailText: TextView = itemView.findViewById(R.id.emailTextRandomUser)
        val countryText: TextView = itemView.findViewById(R.id.countryText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_randomuser, parent, false)
        return RandomUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameText.text = user.name.first + " " + user.name.last
        holder.emailText.text = user.email
        holder.countryText.text = user.location.country
        //holder.profileImage.setImageResource(user.profileImage)

        Glide.with(holder.itemView.context)
            .load(user.picture.medium)
            .placeholder(R.drawable.user_icon)
            .error(R.drawable.ic_launcher_background)
            .into(holder.profileImage)
    }

    override fun getItemCount() = userList.size
}