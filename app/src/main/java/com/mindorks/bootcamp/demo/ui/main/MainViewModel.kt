package com.mindorks.bootcamp.demo.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.demo.data.local.DatabaseService
import com.mindorks.bootcamp.demo.data.remote.NetworkService
import com.mindorks.bootcamp.demo.data.remote.request.DummyRequest
import com.mindorks.bootcamp.demo.di.ActivityScope
import com.mindorks.bootcamp.demo.ui.base.BaseViewModel
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import com.mindorks.bootcamp.instagram.data.model.Dummy
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

class MainViewModel (
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) : BaseViewModel(compositeDisposable
, networkHelper){
    val data = MutableLiveData<String>()
    override fun onCreate() {
      data.postValue("MainViewModel")
    }
}
