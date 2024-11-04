package org.ramt57.bhagwatgita.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ramt57.bhagwatgita.feature.gita.data.networking.ApiRoutes

internal val sharedModule = module {
    singleOf(::ApiRoutes)
}

expect val platformModule: Module // Platform specific dependencies goes here