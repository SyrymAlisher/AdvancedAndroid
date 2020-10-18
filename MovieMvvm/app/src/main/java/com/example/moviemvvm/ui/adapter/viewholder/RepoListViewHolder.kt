package com.example.moviemvvm.ui.adapter.viewholder

import android.content.Intent
import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemvvm.data.model.Item
import com.example.moviemvvm.viewmodel.RepoListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_repo_list_item.view.*
import com.example.moviemvvm.BR
import com.example.moviemvvm.R

class RepoListViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val repoListViewModel: RepoListViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage = itemView.thunm
    fun setup(itemData: Item) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load("https://image.tmdb.org/t/p/w500"+itemData.poster_path).into(avatarImage);

//        itemView.onClick {
//            val bundle = bundleOf("url" to itemData.html_url)
//            itemView.findNavController()
//                .navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
//        }
//        itemView.setOnClickListener{
//            val context = itemView.context
//            val intent = Intent(context, MovieDetailActivity::class.java)
//            intent.putExtra("title", itemData.title)
//            intent.putExtra("budget", itemData.budget)
//            intent.putExtra("overview", itemData.overview)
//            intent.putExtra("poster_path","https://image.tmdb.org/t/p/w500"+ itemData.poster_path)
//            intent.putExtra("release_date", itemData.release_date)
//            intent.putExtra("vote_average", itemData.vote_average)
//            context.startActivity(intent)
//
//        }
    }
}