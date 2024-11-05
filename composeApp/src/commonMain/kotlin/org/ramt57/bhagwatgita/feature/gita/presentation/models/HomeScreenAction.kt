package org.ramt57.bhagwatgita.feature.gita.presentation.models

sealed interface HomeScreenAction{
    data object  OnRefresh: HomeScreenAction
}