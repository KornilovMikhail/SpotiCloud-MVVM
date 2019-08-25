package com.github.jaskelai.spoticloud.ui.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.github.jaskelai.spoticloud.domain.interactors.CommonAuthUseCase
import com.github.jaskelai.spoticloud.ui.navigation.router.GlobalRouter
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val globalRouter: GlobalRouter,
    private val commonAuthUseCase: CommonAuthUseCase
) : ViewModel(), LifecycleObserver {

    private var isFirst = true

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun navigateToStartScreen() {
        if (isFirst) {
            if (commonAuthUseCase.checkAuth()) {
                globalRouter.navigateToStartScreen()
            } else {
                globalRouter.navigateToBottomNavScreen()
            }
            isFirst = false
        }
    }
}
