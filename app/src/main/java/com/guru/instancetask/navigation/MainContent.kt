package com.guru.instancetask.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.guru.instancetask.navigation.Routes
import com.guru.instancetask.screens.AddOrEditTaskScreen
import com.guru.instancetask.screens.HomeScreens
import com.guru.instancetask.screens.SplashScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainContent() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = Routes.splash
    ) {
        composable(
            Routes.splash,
            enterTransition = null,
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            SplashScreen(navController)
        }

        composable(
            Routes.home,
            enterTransition = null,
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            popEnterTransition = null,
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            HomeScreens(navController = navController)
        }
        composable(
            Routes.addOrEdit + "?edit={edit}&taskId={taskId}",
            arguments = listOf(
                navArgument(name = "edit") {
                    type = NavType.BoolType
                    defaultValue = false
                },
                navArgument(name = "taskId") {
                    type = NavType.LongType
                    defaultValue = 0L
                }
            ),
            enterTransition = null,
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            popEnterTransition = null,
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) { backStackEntry ->
            AddOrEditTaskScreen(
                navController,
                backStackEntry.arguments?.getBoolean("edit"),
                backStackEntry.arguments?.getLong("taskId"),
            )
        }
    }
}





