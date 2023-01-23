package com.guru.instancetask.utils

import android.content.Context
import com.guru.instancetask.BuildConfig
import com.guru.instancetask.data.MyObjectBox
import io.objectbox.BoxStore
import io.objectbox.android.AndroidObjectBrowser

object ObjectBox {
     var store: BoxStore?=null
        private set

    fun init(context: Context) {
        store = MyObjectBox.builder()
                .androidContext(context.applicationContext)
                .build()
        if (BuildConfig.DEBUG) {
            AndroidObjectBrowser(store).start(context)
        }
    }
}