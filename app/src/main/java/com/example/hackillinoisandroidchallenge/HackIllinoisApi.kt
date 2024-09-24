package com.example.hackillinoisandroidchallenge
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class Location(
    val description: String,
    val latitude: Double,
    val longitude: Double
)

data class Event(
    val id: String,
    val name: String,
    val description: String,
    val startTime: Long,
    val endTime: Long,
    val locations: List<Location>,
    val eventType: String, // Add event type
    val points: Int
)

// Wrapper class to match the JSON structure
data class EventResponse(
    val events: List<Event>
)


interface HackIllinoisApiService {
    @GET("event/")
    suspend fun getEvents(): EventResponse
}



object RetrofitInstance {
    val api: HackIllinoisApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://adonix.hackillinois.org/")  // Base URL for the API
            .addConverterFactory(GsonConverterFactory.create())  // Converts JSON to Kotlin objects
            .build()
            .create(HackIllinoisApiService::class.java)
    }
}




