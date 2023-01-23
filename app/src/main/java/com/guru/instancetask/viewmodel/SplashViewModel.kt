package com.guru.instancetask.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.guru.instancetask.navigation.Routes
import com.guru.instancetask.utils.UIScope
import com.guru.instancetask.utils.scope
import kotlinx.coroutines.delay

class SplashViewModel: ViewModel() {
    val navigation = mutableStateOf<UIScope?>(null)
    init {
        navigation.scope{ navHostController, lifecycleOwner, toaster ->
            delay(4000L)
            navHostController.popBackStack()
            navHostController.navigate(Routes.home)
        }
    }
}