// MARK: - LoadBoardScreen.kt
// The main Load Board UI screen using Jetpack Compose.

package com.royo.logistics.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.royo.logistics.data.NetworkService
import com.royo.logistics.data.model.Load
import kotlinx.coroutines.launch

@Composable
fun LoadBoardScreen() {
    val coroutineScope = rememberCoroutineScope()
    var loads by remember { mutableStateOf<List<Load>>(emptyList()) }
    var statusText by remember { mutableStateOf("Ready to fetch loads...") }

    Scaffold(topBar = { TopAppBar(title = { Text("RoYo Logistics") }) }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("RoYo Load Board", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                statusText = "Fetching data..."
                coroutineScope.launch {
                    loads = NetworkService.fetchLoads()
                    statusText = "Found ${loads.size} loads."
                }
            }) {
                Text("Simulate API Call")
            }
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(statusText, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))

            if (loads.isNotEmpty()) {
                loads.forEach { load ->
                    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(load.route, style = MaterialTheme.typography.titleMedium)
                            Text("Rate: $${load.rate} | Distance: ${load.distance} km", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}
