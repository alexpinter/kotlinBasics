package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.model.RUser
import com.example.kotlinbasics.model.RandomUserResponse
import com.example.kotlinbasics.model.User
import com.example.kotlinbasics.model.WeatherResponse
import com.example.kotlinbasics.network.RandomUserService
import com.example.kotlinbasics.network.WeatherService
import com.example.myapplication.adapter.RandomUserAdapter
import com.example.myapplication.adapter.UserAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_users)


        val recyclerView: RecyclerView = findViewById(R.id.randomUserListRecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try{
                val  randomUsers = fetchrandomUserList()
                if (!randomUsers.isNullOrEmpty()){
                    recyclerView.adapter = RandomUserAdapter(randomUsers)
                }
            }catch (e: Exception){
                Log.e("HIBA randomUserlistActivity", "Hiba a lista megjelenítésben")
            }

        }

        //fetchrandomUserList();
    }
    private suspend fun fetchrandomUserList() :List<RUser>? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val randomuserService = retrofit.create(RandomUserService::class.java)

        return withContext(Dispatchers.IO){
            try {
                val response = randomuserService.getRandomUsers(10)
                response.results
            }catch (e: Exception){
                Log.e("UserListActivity" , "Error fetching user list")
                null
            }
        }
    }
}