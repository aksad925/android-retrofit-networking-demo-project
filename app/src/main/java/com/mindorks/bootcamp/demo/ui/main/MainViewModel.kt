package com.mindorks.bootcamp.demo.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.demo.data.local.DatabaseService
import com.mindorks.bootcamp.demo.data.remote.NetworkService
import com.mindorks.bootcamp.demo.data.remote.request.DummyRequest
import com.mindorks.bootcamp.demo.di.ActivityScope
import com.mindorks.bootcamp.instagram.data.model.Dummy
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
        private val compositeDisposable: CompositeDisposable,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) {

    companion object {
        const val TAG = "MainViewModel"
    }

    val dummies = MutableLiveData<List<Dummy>>()

    fun getDummies() {
        compositeDisposable.add(
                networkService.doDummyCall(DummyRequest("123"))
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                {
                                    dummies.postValue(it.data)
                                },
                                {
                                    Log.d(TAG, it.toString())
                                }
                        )
        )
    }
}
