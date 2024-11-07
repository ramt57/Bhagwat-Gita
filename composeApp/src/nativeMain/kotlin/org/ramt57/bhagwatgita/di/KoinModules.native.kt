package org.ramt57.bhagwatgita.di

import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module
import org.ramt57.bhagwatgita.core.data.networking.HTTPClientFactory

actual val platformModule = module {
    single { HTTPClientFactory.createHttpClient(Darwin.create()) }
}