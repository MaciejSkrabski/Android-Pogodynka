package com.example.pogodynka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CITY: String = "gliwice,pl"
        val API: String = "c73352e3d33a074760e095d142f76ce4"

        var response:String?
        try {

            Log.d("response test", "haba before")
            thread(start = true) {
                Log.d("Thread","${Thread.currentThread()} has run.")
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=gliwice,pl&APPID=c73352e3d33a074760e095d142f76ce4").readText(Charsets.UTF_8)
                runOnUiThread {testing.text=response}
                Log.d("resp", response)

            }



            //Log.d("resp", response)
            Log.d("response test", "haba after")
        }
        catch (e: Exception) {
            Log.d("error", e.toString())
            response = null
        }
        //testing.text = response

    }


}
