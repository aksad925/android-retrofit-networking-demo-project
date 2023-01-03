package com.mindorks.bootcamp.demo.ui.home

import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.demo.data.local.DatabaseService
import com.mindorks.bootcamp.demo.data.remote.NetworkService
import com.mindorks.bootcamp.demo.di.FragmentScope
import com.mindorks.bootcamp.demo.ui.base.BaseViewModel
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Inject

class HomeViewModel (
        private val databaseService: DatabaseService,
        private val networkService: NetworkService,
         networkHelper: NetworkHelper,
        compositeDisposable: CompositeDisposable
          ): BaseViewModel(compositeDisposable, networkHelper) {

    val data = MutableLiveData<String>()
    override fun onCreate() {
        data.postValue("HomeViewModel")
    }
}
