package com.example.kotlinbasics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.model.User
import com.example.myapplication.adapter.UserAdapter

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val users = listOf(
            User("Gipsz Jakab", "gj@gmail.com", R.drawable.user_icon),
            User("Segg Lyuk", "sly@gmail.com", R.drawable.user_icon),
            User("Ferenc Géza", "fg@hotmail.com", R.drawable.user_icon),
            User("Varga Judit", "gj@citromail.com", R.drawable.user_icon),
            User("Nagy Anna", "gj@freemail.com", R.drawable.user_icon),
            User("Kovács Péter", "gj@gmail.com", R.drawable.user_icon),
            User("Gipsz Jakab", "gj@gmail.com", R.drawable.user_icon),
            User("Gipsz Jakab", "gj@gmail.com", R.drawable.user_icon),
            User("Gipsz Jakab", "gj@gmail.com", R.drawable.user_icon),
            User("Gipsz Jakab", "gj@gmail.com", R.drawable.user_icon)
        )

        val recyclerView: RecyclerView = findViewById(R.id.userListRecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(users)
    }
}