package com.example.hackillinoisandroidchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity

/* Create a schedule page that displays all event details for the hackathon!
 * Make a GET API call to the HackIllinois API event endpoint
 * Recommended: use Retrofit to create HTTP requests
 * Remember to add the libraries you want to use to your build.gradle file!
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
