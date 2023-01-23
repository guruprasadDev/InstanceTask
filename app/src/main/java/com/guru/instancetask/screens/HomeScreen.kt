package com.guru.instancetask.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.guru.instancetask.R
import com.guru.instancetask.ui.theme.*
import com.guru.instancetask.utils.*
import com.guru.instancetask.viewmodel.HomeViewModel
import com.guru.instancetask.widget.AskDeleteAll
import com.guru.instancetask.widget.AskTaskDelete
import com.guru.instancetask.widget.TasksContent
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun HomeScreens(
    navController: NavHostController,
    vm: HomeViewModel = viewModel(),
) {
    val owner = LocalLifecycleOwner.current
    val context = LocalContext.current
    LaunchedEffect(key1 = vm.navigation.value) {
        vm.navigation.forward(navController, owner, Toaster(context))
    }

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = LightSkyColor)

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(top = 20.dp, start = 20.dp),
                        horizontalAlignment = Alignment.Start

                    ) {
                        Text(
                            text = "GP",
                            fontSize = 24.sp,
                            color = Color.White,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)                       // clip to the circle shape
                                .border(2.dp, Color.Gray, CircleShape)
                                .background(Color.Gray)
                                .padding(15.dp)
                        )
                        Text(
                            "E.H.Guru Prasad",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Text(
                            "guruprasad.esambattu@gmail.com",
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.White
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
//                            vm.deleteAllTasks()
//                            scope.launch {
//                                scaffoldState.drawerState.close()
//                            }
                        }
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(id = R.drawable.my_cards),
                        contentDescription = "Boards",
                        Modifier.size(20.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(end = 20.dp))
                    Text("Boards")
                }
                DividerLine()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
//                            vm.deleteAllTasks()
//                            scope.launch {
//                                scaffoldState.drawerState.close()
//                            }
                        }
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(id = R.drawable.my_cards),
                        contentDescription = "My Cards",
                        Modifier.size(20.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(end = 20.dp))
                    Text("My Cards")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
//                            vm.deleteAllTasks()
//                            scope.launch {
//                                scaffoldState.drawerState.close()
//                            }
                        }
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        Modifier.size(25.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(end = 20.dp))
                    Text("Settings")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
//                            vm.deleteAllTasks()
//                            scope.launch {
//                                scaffoldState.drawerState.close()
//                            }
                        }
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "Help",
                        Modifier.size(25.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(end = 20.dp))
                    Text("Help")
                }
            }
        },

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = if (isSystemInDarkTheme()) LightSkyColor else MaterialTheme.colors.onPrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Filled.Menu, "")
                    }
                },
                actions = {

                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                modifier = Modifier
                    .padding(all = 16.dp),
                onClick = {
                    vm.onAddTaskClick()
                },
                text = { Text(text = "Create") },
                icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "Create") })
        }
    ) {
        TasksContent(navController)
        if (vm.greet.value) {
            LottieView(
                json = R.raw.complete,
                iterations = 1,
                modifier = Modifier.fillMaxSize()
            )
        }
        if (vm.askTaskDelete.value) {
            AskTaskDelete()
        }
        if (vm.askDeleteAll.value) {
            AskDeleteAll()
        }
    }
}

@Composable
fun DividerLine() {
    Column {
        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.LightGray)
    }
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

