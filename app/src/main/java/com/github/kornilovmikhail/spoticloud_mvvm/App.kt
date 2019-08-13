package com.github.kornilovmikhail.spoticloud_mvvm

import android.app.Application
import com.github.kornilovmikhail.spoticloud_mvvm.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .factory()
            .create(applicationContext)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
