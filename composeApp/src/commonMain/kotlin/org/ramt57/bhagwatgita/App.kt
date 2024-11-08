package org.ramt57.bhagwatgita

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.ramt57.bhagwatgita.feature.gita.presentation.components.Detail
import org.ramt57.bhagwatgita.feature.gita.presentation.components.Home
import org.ramt57.bhagwatgita.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Home) {
            composable<Home> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { navController.navigate(Detail("Ramayan", "2.5")) }) {
                        Text("Click Me")
                    }
                }
            }
            composable<Detail> {
                val args = it.toRoute<Detail>()
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Info: ${args.chapterName} | ${args.verseNumber}")
                }
            }
        }
    }
}