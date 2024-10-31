package org.ramt57.bhagwatgita

import androidx.compose.ui.window.ComposeUIViewController
import org.ramt57.bhagwatgita.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) { App() }