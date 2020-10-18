package com.example.moviemvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemvvm.data.model.Item
import com.example.moviemvvm.databinding.ViewRepoListItemBinding
import com.example.moviemvvm.viewmodel.RepoListViewModel
import com.example.moviemvvm.ui.adapter.viewholder.RepoListViewHolder

class RepoListAdapter(private val repoListViewModel: RepoListViewModel) :
    RecyclerView.Adapter<RepoListViewHolder>() {
    var repoList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewRepoListItemBinding.inflate(inflater, parent, false)
        return RepoListViewHolder(dataBinding, repoListViewModel)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.setup(repoList[position])
    }

    fun updateRepoList(repoList: List<Item>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }
}