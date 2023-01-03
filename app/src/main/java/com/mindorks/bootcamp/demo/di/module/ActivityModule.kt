package com.mindorks.bootcamp.demo.di.module

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mindorks.bootcamp.demo.data.local.DatabaseService
import com.mindorks.bootcamp.demo.data.remote.NetworkService

import com.mindorks.bootcamp.demo.di.ActivityContext
import com.mindorks.bootcamp.demo.ui.base.BaseActivity
import com.mindorks.bootcamp.demo.ui.main.MainViewModel
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import com.mindorks.bootcamp.demo.utils.ViewModelProviderFactory

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideMainViewModel(
        compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
   databaseService: DatabaseService,
        networkService: NetworkService): MainViewModel =
        ViewModelProviders.of(activity, ViewModelProviderFactory(MainViewModel::class){
            MainViewModel(compositeDisposable, networkHelper, databaseService,networkService)
        }).get(MainViewModel::class.java)
}
