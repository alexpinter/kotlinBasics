package com.example.kotlinbasics
// verem 2
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.model.WeatherResponse
import com.example.kotlinbasics.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {

    private lateinit var textviewTemp: TextView
    private lateinit var textviewMinTemp: TextView
    private lateinit var textviewHumidity: TextView
    private lateinit var textviewWindSpeed: TextView
    private lateinit var edittextCity: EditText
    private lateinit var buttonCity: Button
    private lateinit var textviewCity: TextView
    private var varos = "";
    private val apiKey = "7b1187ac79f71d9b4fb5f84c526745c4"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)
        textviewTemp = findViewById(R.id.textview_temp)
        textviewMinTemp = findViewById(R.id.textview_tempMin)
        textviewHumidity = findViewById(R.id.textview_humidity)
        textviewWindSpeed = findViewById(R.id.textview_windSpeed)
        edittextCity = findViewById(R.id.edittext_city)
        buttonCity = findViewById(R.id.button_city)
        textviewCity = findViewById(R.id.textview_city)

        buttonCity.setOnClickListener{
            val cityName = edittextCity.text
            if (cityName.isNotBlank()){
                varos = cityName.toString()
            }
            fetchWeatherData(varos)
        }


    }

    private fun fetchWeatherData(varos: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService = retrofit.create(WeatherService::class.java)

        val call = weatherService.getWeather(varos, "metric", apiKey)
        call.enqueue(object: Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ){
                if (response.isSuccessful){
                    val weatherResponse = response.body()
                    if (weatherResponse != null) {
                        val weatherInfo = weatherResponse.main.temp
                        textviewTemp.text = "Hőmérséklet: " + weatherInfo.toString() + " C"
                        val weatherInfoMin = weatherResponse.main.temp_min
                        textviewMinTemp.text = "Minimum hőmérséklet: " + weatherInfoMin.toString() + " C"
                        val weatherInfoHumidity = weatherResponse.main.humidity
                        textviewHumidity.text = "Páratartalom: " + weatherInfoHumidity.toString()
                        val weatherInfoWind = weatherResponse.wind.speed
                        textviewWindSpeed.text = "Szél sebesség: " + weatherInfoWind.toString() + " Km/h"
                        textviewCity.text = varos
                    }
                }

            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable){
                Log.e("Hiba", "Hiba az API kérés során.")
            }

        })

    }

}