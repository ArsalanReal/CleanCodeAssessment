package com.dev.nytimes.di

import com.dev.nytimes.platform.SharedPreferenceHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Shared Preference DI Module.
 *
 */
val SharedPrefDependency = module {

    factory { SharedPreferenceHelper(androidContext()) }
}