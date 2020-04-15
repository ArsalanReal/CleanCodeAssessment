package com.dev.nytimes.di

import com.dev.nytimes.repository.NewsRepository
import org.koin.dsl.module

/**
 * Repository DI module.
 * Provides Repo dependency.
 */
val RepoDependency = module {

    factory {
        NewsRepository()
    }

}