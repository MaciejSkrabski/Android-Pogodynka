package com.example.pogodynka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.URL
import kotlin.concurrent.thread
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                //.add(R.id.container, LoginFragment())
                .add(R.id.container, FragmentWeather()) // omit LoginFragment for testing
                .commit()
        }

        //callApi(CITY)

        //testing.text = response

    }




}
