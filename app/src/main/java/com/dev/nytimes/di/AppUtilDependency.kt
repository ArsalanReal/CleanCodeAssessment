package com.dev.nytimes.di

import com.dev.nytimes.utils.AppUtils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * DI module for App Util dependency.
 */
val AppUtilDependency = module {

    factory { AppUtils(androidContext()) }
}