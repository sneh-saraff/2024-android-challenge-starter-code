package com.example.hackillinoisandroidchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/* Create a schedule page that displays all event details for the hackathon!
 * Make a GET API call to the HackIllinois API event endpoint
 * Recommended: use Retrofit to create HTTP requests
 * Remember to add the libraries you want to use to your build.gradle file!
*/

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: EventViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = EventViewModel()

        // Setup RecyclerView
        recyclerView = findViewById(R.id.recyclerView)  // Make sure to use the correct ID
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = viewModel.adapter  // Set the adapter

        // Fetch events
        viewModel.fetchEvents()
    }
}
