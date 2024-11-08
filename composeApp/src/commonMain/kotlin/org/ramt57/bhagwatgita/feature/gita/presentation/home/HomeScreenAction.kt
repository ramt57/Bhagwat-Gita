package org.ramt57.bhagwatgita.feature.gita.presentation.home

sealed interface HomeScreenAction{
    data object  OnRefresh: HomeScreenAction
}