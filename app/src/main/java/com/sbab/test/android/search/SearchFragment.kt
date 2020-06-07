package com.sbab.test.android.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sbab.test.android.R
import com.sbab.test.android.SearchState
import com.sbab.test.android.databinding.FragmentSearchBinding
import com.sbab.test.android.extensions.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
@FlowPreview
class SearchFragment : Fragment(R.layout.fragment_search), TextWatcher {

    @FlowPreview
    @InternalCoroutinesApi
    private val viewModel
            by activityScopedViewModel {
                injector.searchViewModel
            }

    private val binding
            by viewBinding(
                FragmentSearchBinding::bind
            )

    private val searchResultAdapter by lazy {
        SearchResultAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.searchResult.observe(this) {
            if (it is SearchState.Success) {
                searchResultAdapter.submitList(it.searchResult)
            }
        }

        binding.searchPhotosInputField.setText(viewModel.searchQuery)
        binding.searchPhotosInputField.addTextChangedListener(this)


        binding.clearSearch.setOnClickListener {
            binding.searchPhotosInputField.setText("")
        }

        binding.results.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchResultAdapter
        }


    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (s.isNotEmpty()) binding.clearSearch.visibility =
            VISIBLE else binding.clearSearch.visibility = GONE

        viewModel.search(s)
    }
}