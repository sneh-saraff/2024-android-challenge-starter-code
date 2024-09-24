package com.example.hackillinoisandroidchallenge
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackillinoisandroidchallenge.databinding.ItemEventBinding
import java.text.SimpleDateFormat
import java.util.*

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private var eventList = listOf<Event>()

    // Update the list of events and notify the RecyclerView
    fun submitList(list: List<Event>) {
        eventList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = eventList.size

    class EventViewHolder(private val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event) {
            binding.textViewEventName.text = event.name
            binding.textViewEventDescription.text = event.description
            binding.textViewEventType.text = event.eventType // Update with actual event type
            binding.textViewPoints.text = event.points.toString()
            val formattedStartTime = formatTime(event.startTime)
            val formattedEndTime = formatTime(event.endTime)
            binding.textViewStartEndTime.text = "$formattedStartTime - $formattedEndTime"

            if (event.locations.isNotEmpty()) {
                val location = event.locations[0]
                binding.textViewLocation.text = location.description
            }
        }

        private fun formatTime(epoch: Long): String {
            val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault())  // Define date format
            val date = Date(epoch * 1000)  // Convert epoch to Date (since epoch is now in milliseconds)
            return sdf.format(date)  // Return formatted date string
        }
    }
}
