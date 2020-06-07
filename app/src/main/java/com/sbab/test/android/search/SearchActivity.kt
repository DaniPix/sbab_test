package com.sbab.test.android.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sbab.test.android.R
import com.sbab.test.android.databinding.ActivitySearchBinding
import com.sbab.test.android.extensions.viewBinding
import kotlinx.coroutines.InternalCoroutinesApi

class SearchActivity : AppCompatActivity(R.layout.activity_search) {

    private val binding
            by viewBinding(
                ActivitySearchBinding::inflate
            )

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container, SearchFragment(), "searchFragmentTag"
            ).commitAllowingStateLoss()
    }
}