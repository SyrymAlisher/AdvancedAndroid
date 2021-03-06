package com.example.moviemvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemvvm.databinding.FragmentRepoListBinding
import com.example.moviemvvm.ui.adapter.RepoListAdapter
import com.example.moviemvvm.viewmodel.RepoListViewModel
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class RepoListFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentRepoListBinding
    private lateinit var adapter: RepoListAdapter
    private val repoListViewModel:RepoListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(viewLifecycleOwner)

        }
        viewDataBinding.viewmodel = repoListViewModel

        return viewDataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()
        setupAdapter()
        setObservers()
    }


    private fun setObservers() {
        viewDataBinding.viewmodel?.fetchRepoList()?.observe(viewLifecycleOwner, {
            adapter.updateRepoList(it)
        })
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = RepoListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            repo_list_rv.adapter = adapter
        }
    }

}