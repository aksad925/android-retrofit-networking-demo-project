package com.mindorks.bootcamp.demo.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mindorks.bootcamp.demo.MyApplication
import com.mindorks.bootcamp.demo.R
import com.mindorks.bootcamp.demo.di.component.ActivityComponent
import com.mindorks.bootcamp.demo.di.component.DaggerActivityComponent
import com.mindorks.bootcamp.demo.di.module.ActivityModule
import com.mindorks.bootcamp.demo.ui.base.BaseActivity
import com.mindorks.bootcamp.demo.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {

    private fun addHomeFragment() {
        if (supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit()
        }
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.data.observe(this, Observer {
            tv_message.text = it
        })
    }
    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setUpViews(savedInstanceState: Bundle?) {
        addHomeFragment()
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}
