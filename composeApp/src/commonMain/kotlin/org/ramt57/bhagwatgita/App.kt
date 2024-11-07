package org.ramt57.bhagwatgita

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import bhagwatgita.composeapp.generated.resources.Res
import bhagwatgita.composeapp.generated.resources.krishna_arjuna
import multiplatform.network.cmptoast.ToastGravity
import multiplatform.network.cmptoast.showToast
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.ramt57.bhagwatgita.core.presentation.util.ObserveAsEvent
import org.ramt57.bhagwatgita.feature.gita.domain.GitaDataViewModel
import org.ramt57.bhagwatgita.feature.gita.presentation.models.HomeScreenEvent
import org.ramt57.bhagwatgita.feature.gita.presentation.util.toLocalisedString
import org.ramt57.bhagwatgita.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        val viewModel = koinViewModel<GitaDataViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()
        ObserveAsEvent(viewModel.events) {
            when (it) {
                is HomeScreenEvent.Error -> {
                    showToast(
                        message = it.error.toLocalisedString(),
                        backgroundColor = Color.Black,
                        textColor = Color.White,
                        gravity = ToastGravity.Top
                    )
                }
            }
        }
        Column {
            Image(painterResource(Res.drawable.krishna_arjuna), null)
            Text(text = state.value.verses?.verse ?: "Loading...")
        }
    }
}