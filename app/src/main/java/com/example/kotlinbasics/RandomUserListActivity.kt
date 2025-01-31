package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.model.RandomUserResponse
import com.example.kotlinbasics.model.User
import com.example.kotlinbasics.model.WeatherResponse
import com.example.kotlinbasics.network.RandomUserService
import com.example.kotlinbasics.network.WeatherService
import com.example.myapplication.adapter.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_users)


//        val recyclerView: RecyclerView = findViewById(R.id.userListRecyclerview)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = UserAdapter(users)

    }

    private fun fetchrandomUserList() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val randomuserService = retrofit.create(RandomUserService::class.java)

        val call = randomuserService.getRandomUsers(10)
        call.enqueue(object: Callback<RandomUserResponse> {
            override fun onResponse(
                call: Call<RandomUserResponse>,
                response: Response<RandomUserResponse>
            ){
                if (response.isSuccessful){
                    val randomUserResponse = response.body()
                    if (randomUserResponse != null) {
                        Log.e("Eredmény", randomUserResponse.results.toString())
                    }
                }

            }

            override fun onFailure(call: Call<RandomUserResponse>, t: Throwable){
                Log.e("Hiba", "Hiba az API kérés során.")
            }

        })

    }

}