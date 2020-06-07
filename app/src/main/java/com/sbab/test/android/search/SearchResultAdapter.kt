package com.sbab.test.android.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sbab.test.android.R
import com.sbab.test.android.data.SearchResult
import kotlinx.android.synthetic.main.layout_search_resut_item.view.*

class SearchResultAdapter :
    ListAdapter<SearchResult, SearchResultAdapter.PhotoViewHolder>(
        SearchSuggestionDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_search_resut_item, parent, false)

        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val suggestion = getItem(position)
        holder.bind(suggestion)
    }

    inner class PhotoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val photo: ImageView by lazy { itemView.photo }
        private val title: TextView by lazy { itemView.title }

        fun bind(searchResult: SearchResult) {
            Glide
                .with(itemView.context)
                .load(searchResult.photoUrl)
                .skipMemoryCache(false)
                .apply(RequestOptions.circleCropTransform())
                .into(photo)

            title.text = searchResult.photoTitle
        }
    }

    class SearchSuggestionDiffCallback : DiffUtil.ItemCallback<SearchResult>() {
        override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
            return oldItem.photoUrl == newItem.photoUrl
        }

        override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
            return oldItem == newItem
        }
    }
}