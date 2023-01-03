package com.mindorks.bootcamp.demo.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
    protected val compositeDisposable: CompositeDisposable,
    protected val networkHelper: NetworkHelper
) : ViewModel() {

    val messageStringId = MutableLiveData<Int>()
    val messageString = MutableLiveData<String>()

    protected fun checkInternetConnection(): Boolean{
        return networkHelper.isNetworkConnected()
    }

    protected fun handleNetworkError(err: Throwable){
        //handle error
    }
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    abstract fun onCreate()
}