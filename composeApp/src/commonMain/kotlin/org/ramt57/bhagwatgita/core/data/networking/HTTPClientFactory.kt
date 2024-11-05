package org.ramt57.bhagwatgita.core.data.networking

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HTTPClientFactory {
    fun createHttpClient(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            install(Logging){
                level = LogLevel.ALL
                filter { request ->
                    request.url.host.contains("vedicscriptures.github.io")
                }
            }
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
            }
        }
    }
}
