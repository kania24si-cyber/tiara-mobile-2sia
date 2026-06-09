package com.example.tiara_distinctive.Home.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tiara_distinctive.data.model.NewsModel
import com.example.tiara_distinctive.databinding.ItemNewsBinding

class NewsAdapter(
    private val newsList: List<NewsModel>
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(
        val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsList[position]

        holder.binding.tvTitle.text = item.title

        holder.binding.tvBody.text = item.summary
    }

    override fun getItemCount(): Int = newsList.size
}