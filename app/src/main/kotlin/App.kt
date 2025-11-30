// MARK: - App.kt
// The main application entry point and setup for the Android app.

package com.royo.logistics

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.royo.logistics.ui.LoadBoardScreen

class RoYoApplication : Application() {
    // This is where Dagger/Hilt setup, Crashlytics, and other global services would be initialized
    override fun onCreate() {
        super.onCreate()
        println("RoYo Android Application started.")
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Set the main screen using Jetpack Compose
            LoadBoardScreen()
        }
    }
}
