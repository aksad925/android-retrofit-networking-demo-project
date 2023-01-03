package com.mindorks.bootcamp.demo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mindorks.bootcamp.demo.MyApplication
import com.mindorks.bootcamp.demo.R
import com.mindorks.bootcamp.demo.di.component.DaggerFragmentComponent
import com.mindorks.bootcamp.demo.di.component.FragmentComponent
import com.mindorks.bootcamp.demo.di.module.FragmentModule
import com.mindorks.bootcamp.demo.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    companion object {

        val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId(): Int = R.layout.fragment_home

    override fun setUpViews(view: View) {

    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.data.observe(this, Observer {
            tv_message.text = it
        })
    }
    override fun injectDependencies(fragmentComponent: FragmentComponent) {
      fragmentComponent.inject(this)
    }
}
