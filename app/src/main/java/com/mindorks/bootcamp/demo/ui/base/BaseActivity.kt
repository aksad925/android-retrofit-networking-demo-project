package com.mindorks.bootcamp.demo.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mindorks.bootcamp.demo.MyApplication
import com.mindorks.bootcamp.demo.di.component.ActivityComponent
import com.mindorks.bootcamp.demo.di.component.DaggerActivityComponent
import com.mindorks.bootcamp.demo.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        setContentView(provideLayoutId())
        setupObservers()
        setUpViews(savedInstanceState)
    }

   protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            showMessage(it)
        })

        viewModel.messageStringId.observe(this, Observer {
            showMessage(it)
        })
    }

    private fun buildActivityComponent() =
        DaggerActivityComponent.builder().applicationComponent(
            (application as MyApplication).applicationComponent
        ).activityModule(ActivityModule(this)).build()


    fun showMessage(message: String) =
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun setUpViews(savedInstanceState: Bundle?)

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)
}