package com.dev.nytimes.di

import com.dev.nytimes.screens.news.list.NewsListUseCase
import org.koin.dsl.module

/**
 * Use case DI module.
 * Provide Use case dependency.
 */
val UseCaseDependency = module {

    factory {
        NewsListUseCase()
    }
}