package com.walter.doggo_compose.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun DoggoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if(darkTheme) DarkColors else LightColors,
        typography = DoggoTypography,
        content = content
    )
}

private val LightColors = lightColors(
    primary = Indigo300,
    primaryVariant = Indigo300Dark,
    onPrimary = Color.White,
    secondary = Indigo300Light,
    secondaryVariant = Indigo300Dark,
    onSecondary = Color.White,
    error = Color.Red
)

private val DarkColors = darkColors(
    primary = Indigo300,
    primaryVariant = Indigo300Dark,
    onPrimary = Color.Black,
    secondary = Indigo300Light,
    secondaryVariant = Indigo300Dark,
    onSecondary = Color.Black,
    error = Color.Red
)
