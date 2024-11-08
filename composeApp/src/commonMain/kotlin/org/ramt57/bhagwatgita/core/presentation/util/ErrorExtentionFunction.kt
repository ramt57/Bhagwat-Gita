package org.ramt57.bhagwatgita.core.presentation.util

import bhagwatgita.composeapp.generated.resources.Res
import bhagwatgita.composeapp.generated.resources.*
import org.jetbrains.compose.resources.getString
import org.ramt57.bhagwatgita.core.domain.util.NetworkError

suspend fun NetworkError.toLocalisedString(): String {
    return when (this) {
        NetworkError.REQUEST_TIMEOUT -> getString(Res.string.network_error_request_timeout)
        NetworkError.UNAUTHORIZED -> getString(Res.string.network_error_unauthorized)
        NetworkError.CONFLICT -> getString(Res.string.network_error_conflict)
        NetworkError.TOO_MANY_REQUESTS -> getString(Res.string.network_error_too_many_requests)
        NetworkError.NO_INTERNET -> getString(Res.string.network_error_no_internet)
        NetworkError.PAYLOAD_TOO_LARGE -> getString(Res.string.network_error_payload_too_large)
        NetworkError.SERVER_ERROR -> getString(Res.string.network_error_server_error)
        NetworkError.SERIALIZATION -> getString(Res.string.network_error_serialization)
        NetworkError.UNKNOWN -> getString(Res.string.network_error_unknown)
    }
}