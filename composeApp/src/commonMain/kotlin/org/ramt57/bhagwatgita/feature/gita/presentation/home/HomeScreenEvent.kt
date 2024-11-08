package org.ramt57.bhagwatgita.feature.gita.presentation.home

import org.ramt57.bhagwatgita.core.domain.util.NetworkError

sealed interface HomeScreenEvent {
    data class Error(val error: NetworkError): HomeScreenEvent
}