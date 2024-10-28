package org.ramt57.bhagwatgita

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import bhagwatgita.composeapp.generated.resources.Res
import bhagwatgita.composeapp.generated.resources.compose_multiplatform
import bhagwatgita.composeapp.generated.resources.hello_world
import org.jetbrains.compose.resources.stringResource
import org.ramt57.bhagwatgita.ui.theme.AppTheme
import org.ramt57.bhagwatgita.ui.theme.Spacing

@Composable
@Preview
fun App() {
    AppTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedButton(onClick = { showContent = !showContent }) {
                Text(stringResource(Res.string.hello_world))
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text(
                        text = "Compose: $greeting"
                    )
                }
            }
        }
    }
}