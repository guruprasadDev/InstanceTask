package com.guru.instancetask

import android.app.Application
import com.guru.instancetask.utils.ObjectBox

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }
}