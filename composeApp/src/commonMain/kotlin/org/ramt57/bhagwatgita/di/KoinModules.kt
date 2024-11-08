package org.ramt57.bhagwatgita.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.ramt57.bhagwatgita.feature.gita.data.networking.RemoteGitaDataSource
import org.ramt57.bhagwatgita.feature.gita.domain.GitaDataSource
import org.ramt57.bhagwatgita.feature.gita.presentation.home.HomeViewModel

internal val sharedModule = module {
    viewModelOf(::HomeViewModel)
    singleOf(::RemoteGitaDataSource).bind<GitaDataSource>()
}

expect val platformModule: Module // Platform specific dependencies goes here