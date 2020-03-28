package com.example.pogodynka

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.android.synthetic.main.fragment_weather.view.*
import java.net.URL
import kotlin.concurrent.thread
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*


class FragmentWeather : Fragment() {
    val CITY: String = "gliwice,pl"
    val API: String = "c73352e3d33a074760e095d142f76ce4"
    var response:String? = null
    var successful:Boolean = true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        // Snippet from "Navigate to the next Fragment" section goes here.

        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        view.next_button.setOnClickListener { getWeather(city_input.text.toString()) }
        view.clear_button.setOnClickListener { city_input.text = null }


        return view
    }

    // http://openweathermap.org/img/wn/10d@2x.png
    // http://openweathermap.org/img/wn/$ICON@2x.png

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getWeather(CITY)

    }


    fun getWeather(city: String?){
        try {
            callApi(city)
            if (successful) {
                val gson = Gson()
                val parsed = gson.fromJson(response, DataResponse::class.java)
                Log.d("parsed", parsed.toString())
                Picasso.get().load("https://openweathermap.org/img/wn/${parsed.weather[0].icon}@2x.png").into(image)

                city_name.text = parsed.name
                temperature.text = (parsed.main.temp-273.15).toInt().toString() + "ºC"
                pressure.text = parsed.main.pressure.toString()
                desc.text = parsed.weather[0].description
                sunrise.text = dateFormatter(parsed.sys.sunrise.toLong())
                sunset.text = dateFormatter(parsed.sys.sunset.toLong())
                datetime.text = dateFormatter(parsed.dt.toLong())
            }
        } catch (e: Error) {
            Toast.makeText(activity, e.message, Toast.LENGTH_SHORT)
        }
    }

    fun callApi(city: String?){

        try {
            thread(start = true) {
                Log.d("Thread","${Thread.currentThread()} has run.")
                try {
                    response =
                        URL("https://api.openweathermap.org/data/2.5/weather?q=$city&APPID=$API").readText(
                            Charsets.UTF_8
                        )
                }
                catch(e: Error){
                    successful = false
                    Log.d("Connection error", e.message)
                    Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
                }
                Log.d("resp", response)


            }.join()
        }
        catch (e: Exception) {
            Log.d("error", e.toString())
            response = null
        }
    }


    fun dateFormatter(epoch: Long): String {
        // epoch = 1557954848
        val date = Date(epoch * 1000L)
        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm")
        return sdf.format(date)
        // returned value = "2019-05-15 14:14:08.000000"
    }
}
