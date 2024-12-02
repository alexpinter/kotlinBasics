package com.example.kotlinbasics
// verem
import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import okhttp3.Address
import okhttp3.Route

class MainActivity : AppCompatActivity() {

    //comment 2
    private lateinit var openGreetingButton: Button
    private lateinit var openCalculatorButton: Button
    private lateinit var openWeatherButton: Button
/*-----------------------------------------------------------------
    data class Root(
        val universityName: String,
        val departments: List<Department>
    )
    data class Department(
        val name: String,
        val professors: List<Professor>,
        val students: List<Student>
    )
    data class Professor(
        val name: String,
        val subject: String
    )
    data class Student(
        val name: String,
        val studentId: String,
        val courses: List<Course>
    )
    data class Course(
        val courseName: String,
        val credits: Int
    )
//--------------------------------------------------------

    data class Root2(
        val airportName: String,
        val terminals: List<Terminal>
    )
    data class Terminal(
        val terminalName: String,
        val flights: List<Flight>
    )
    data class Flight(
        val flightNumber: String,
        val destination: String,
        val airline: Airline
    )
    data class Airline(
        val name: String,
        val country: String
    )
    //------------------------------------------------------------------------

    data class Root3(
        val publisherName: String,
        val authors: List<Author>
    )
    data class Author(
        val authorName: String,
        val books: List<Book>
    )
    data class Book(
        val title: String,
        val year: Int,
        val ratings: List<Rating>
    )
    data class Rating(
        val rating: Int,
        val comment: String
    )
//--------------------------------------------------------------------

    data class Root4(
        val agencyName: String,
        val customers: List<Customer>
    )
    data class Customer(
        val customerId: String,
        val name: String,
        val email: String,
        val  bookings: List<Booking>
    )
    data class Booking(
        val bookingId: String,
        val packages: Package,
        val rating: Ratings
    )
    data class Package(
        val packageId: String,
        val destination: String,
        val durationDays: Int,
        val price: Int,
        val activities: List<Activity>
    )
    data class Activity(
        val activityName: String,
        val type: String
    )
    data class Ratings(
        val score: String,
        val comment: String
    )

    //------------------------gyak 2-------------------------------
    //valtoztatas

    data class Root1(
        val orderId: String,
        val customer: Customers,
        val orderItems: List<OrderItem>,
        val shipping: Shipping,
        val payment: Payment,
        val status: String
    )

    data class Customers(
        val customerId: String,
        val name: String,
        val email: String,
        val phone: String
    )

    data class OrderItem(
        val itemId: String,
        val productName: String,
        val quantity: Int,
        val pricePerUnit: Double,
        val discount: Double
    )

    data class Shipping(
        val address: Address,
        val shippingMethod: String,
        val estimatedDeliveryDays: Int

    )
    data class Address(
        val street: String,
        val city: String,
        val postalCode: Int,
        val country: String
    )
    data class Payment(
        val paymentMethod: String,
        val totalAmount: Double,
        val paid: Boolean
    )
//------------------------------------------------------------------------------------

    data class Root_2(
        val projectName: String,
        val subject: String,
        val durationWeeks: Int,
        val teamMembers: List<TeamMember>,
        val assignments: List<Assignment>,
        val completed: Boolean

    )
    data class TeamMember(
        val studentId: String,
        val name: String,
        val grade: Int,
        val hasCompleted: Boolean
    )
    data class Assignment(
        val assignmentName: Assignment,
        val maxPoints: Int,
        val studentScores: StudentScore
    )
    data class StudentScore(
        val STU123: Int,
        val STU124: Int,
        val STU125: Int
    )
//--------------------------------------------------------------------------------------
    data class Root_3(
        val cityName: String,
        val transitSystem: TransitSystem,
        val controlCenter: ControlCenter

    )
    data class TransitSystem(
        val buses: List<Buses>,
        val trams: List<Trams>

    )
    data class Buses(
        val routeNumber: Int,
        val routeName: String,
        val vehicles: List<Vehicles>,
        val schedule: Schedule

    )
    data class Vehicles(
        val vehicleId: String,
        val capacity: Int,
        val currentLocation: CurrentLocation,
        val status: String
    )
    data class CurrentLocation(
        val latitde: Double,
        val longitude: Double
    )
    data class Schedule(
        val weekday: List<Weekday>,
        val weekend: List<Weekend>
    )
    data class Weekday(
        val departureTime: String,
        val arrivalTime: String
    )
    data class Weekend(
        val departureTime: String,
        val arrivalTime: String
    )
    data class Trams(
        val routeNumber: Int,
        val routeName: String,
        val vehicles: List<Vehicles>,
        val schedule: Schedule
    )
    data class ControlCenter(
        val contactNumber: String,
        val emergencyContacts: List<EmergencyContats>
    )
    data class EmergencyContats(
        val name: String,
        val phone: String,
        val shift: String
    )
*/



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        //ui elemek inicializálása
        openGreetingButton = findViewById(R.id.openGreetingButton)
        openCalculatorButton = findViewById(R.id.openCalcultorButton)
        openWeatherButton = findViewById(R.id.openWeatherButton)

        openGreetingButton.setOnClickListener(){
            //intent létrehozása és activity indítása
            val intent = Intent(this,GreetingActivity::class.java)
            startActivity(intent)
        }

        openCalculatorButton.setOnClickListener(){
            //intent létrehozása és activity indítása
            val intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }
        openWeatherButton.setOnClickListener(){
            //intent létrehozása és activity indítása
            val intent = Intent(this,WeatherActivity::class.java)
            startActivity(intent)
        }




    }//oncreate



}//class
