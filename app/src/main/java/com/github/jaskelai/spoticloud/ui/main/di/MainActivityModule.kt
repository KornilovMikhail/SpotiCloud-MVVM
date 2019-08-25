package com.github.jaskelai.spoticloud.ui.main.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.jaskelai.spoticloud.ui.main.MainActivity
import com.github.jaskelai.spoticloud.ui.main.MainViewModel
import com.github.jaskelai.spoticloud.ui.navigation.router.GlobalRouter
import com.github.jaskelai.spoticloud.ui.navigation.router.GlobalRouterCiceroneImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

@Module
abstract class MainActivityModule {

    @Module
    companion object {

        @Provides
        @MainActivityScope
        @JvmStatic
        fun provideNavigator(mainActivity: MainActivity): Navigator {
            return SupportAppNavigator(mainActivity, mainActivity.getContainerId())
        }
    }

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @MainActivityScope
    abstract fun provideRouter(router: GlobalRouterCiceroneImpl): GlobalRouter
}
