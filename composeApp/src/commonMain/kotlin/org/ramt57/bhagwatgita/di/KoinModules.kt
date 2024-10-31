package org.ramt57.bhagwatgita.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ramt57.bhagwatgita.data.ApiService

internal val sharedModule = module {
    singleOf(::ApiService)
}

expect val platformModule: Module // Platform specific dependencies goes here