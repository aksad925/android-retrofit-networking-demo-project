package com.mindorks.bootcamp.demo.ui.base

import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.demo.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

class BaseItemViewModel<T : Any>(
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(compositeDisposable, networkHelper) {
    val data = MutableLiveData<T>()
    fun manualCleared() = onCleared()

    override fun onCreate() {

    }

    fun updateData(data: T) {
        this.data.postValue(data)
    }
}