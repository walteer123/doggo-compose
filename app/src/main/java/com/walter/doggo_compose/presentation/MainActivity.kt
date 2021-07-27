package com.walter.doggo_compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.walter.doggo_compose.AppRouter
import com.walter.doggo_compose.presentation.theme.DoggoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoggoTheme {
                Surface {
                    AppRouter()
                }
            }
        }
    }
}
