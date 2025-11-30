// MARK: - NetworkService.kt
// Handles API calls, typically using Retrofit.

package com.royo.logistics.data

import com.royo.logistics.data.model.Load
import kotlinx.coroutines.delay
import kotlin.random.Random

object NetworkService {

    // Placeholder for actual Retrofit interface
    private val baseURL = "https://api.royo.uz/v1/" // Placeholder URL

    suspend fun fetchLoads(): List<Load> {
        println("-> Attempting to fetch loads from API.")
        
        // --- Simulated Network Delay (Replace with real logic later) ---
        delay(1500)
        
        println("<- Simulated API Response received.")

        // On successful connection:
        return listOf(
            Load(route = "Tashkent → Almaty", rate = 950, distance = 840),
            Load(route = "Samarkand → Bishkek", rate = 780, distance = 1100),
            Load(route = "Navoi → Astana", rate = 1100, distance = 1600)
        )
    }
}

// MARK: - Data Model (Placeholder)

package com.royo.logistics.data.model

data class Load(
    val route: String,
    val rate: Int,
    val distance: Int
)
