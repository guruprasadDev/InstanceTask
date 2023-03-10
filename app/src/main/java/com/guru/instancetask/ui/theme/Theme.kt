package com.guru.instancetask.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorPalette = darkColors(
    primary = AppColor,
    primaryVariant = AppColorDark,
    secondary = AppColor,
    background = AppDarkColor,
    surface = AppDarkColor,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

val LightColorPalette = lightColors(
    primary = AppColor,
    primaryVariant = AppColorDark,
    secondary = AppColor,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun MyInstanceTaskTheme(darkTheme: Boolean= isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette, content = content
    )
}