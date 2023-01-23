package com.guru.instancetask.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.guru.instancetask.R
import com.guru.instancetask.utils.LottieView
import com.guru.instancetask.utils.forward
import com.guru.instancetask.viewmodel.SplashViewModel

@Composable
fun SplashScreen(
    navController: NavHostController,
    vm: SplashViewModel = viewModel()
) {
    val owner = LocalLifecycleOwner.current
    LaunchedEffect(key1 = vm.navigation.value) {
        vm.navigation.forward(navController, owner)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieView(
                json = R.raw.splashs,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Spacer(
                modifier = Modifier.height(50.dp)
            )
            Text(
                stringResource(
                    id = R.string.app_name
                ),
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primary
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("E.H.Guru Prasad")
        Text(text = "Developed by")
    }
}