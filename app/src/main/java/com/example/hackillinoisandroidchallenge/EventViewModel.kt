package com.example.hackillinoisandroidchallenge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {

    private val hackIllinoisApiService = RetrofitInstance.api
    val adapter = EventAdapter()  // Initialize your adapter

    fun fetchEvents() {
        viewModelScope.launch {
            try {
                val eventResponse = hackIllinoisApiService.getEvents()  // Fetch events
                adapter.submitList(eventResponse.events)  // Pass the events to the adapter
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}
