package org.ramt57.bhagwatgita.feature.gita.presentation

import androidx.compose.runtime.Immutable
import org.ramt57.bhagwatgita.feature.gita.data.models.VerseItem

@Immutable
data class RandomVerseUiState(
    val isLoading: Boolean = false,
    val verses: VerseItem? = null
)