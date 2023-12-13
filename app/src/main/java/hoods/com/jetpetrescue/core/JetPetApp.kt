package hoods.com.jetpetrescue.core

import android.app.Application
import hoods.com.jetpetrescue.features.home.data.Graph

class JetPetApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this@JetPetApp)
    }
}