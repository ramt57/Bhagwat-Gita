package org.ramt57.bhagwatgita

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import bhagwatgita.composeapp.generated.resources.Res
import bhagwatgita.composeapp.generated.resources.krishna_arjuna
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.ramt57.bhagwatgita.feature.gita.domain.GitaDataViewModel
import org.ramt57.bhagwatgita.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        val viewModel = koinViewModel<GitaDataViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()
        Column {
            Image(painterResource(Res.drawable.krishna_arjuna), null)
            Text(text = state.value.verses?.verse?: "Loading...")
        }

    }
}