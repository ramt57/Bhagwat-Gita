package org.ramt57.bhagwatgita.feature.gita.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ramt57.bhagwatgita.core.domain.util.onError
import org.ramt57.bhagwatgita.core.domain.util.onSuccess
import org.ramt57.bhagwatgita.feature.gita.domain.GitaDataSource
import org.ramt57.bhagwatgita.feature.gita.presentation.RandomVerseUiState

class HomeViewModel(private val dataSource: GitaDataSource) : ViewModel() {
    private val _randomVerseUiState = MutableStateFlow(RandomVerseUiState())

    val state = _randomVerseUiState.onStart {
        getRandomVerse()
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(stopTimeoutMillis = 2000L),
        RandomVerseUiState()
    )

    private val _events = Channel<HomeScreenEvent>()
    val events = _events.consumeAsFlow()

    private fun getRandomVerse() {
        viewModelScope.launch {
            _randomVerseUiState.update { it.copy(isLoading = true) }
            dataSource.getRandomSlokByChapter(1).onSuccess { verseItem ->
                _randomVerseUiState.update { it.copy(isLoading = false, verses = verseItem) }
            }.onError { error ->
                _randomVerseUiState.update { it.copy(isLoading = false) }
                _events.send(HomeScreenEvent.Error(error = error))
            }
        }
    }

    fun onAction(action: HomeScreenAction){
        when(action){
            HomeScreenAction.OnRefresh -> {

            }
        }
    }
}