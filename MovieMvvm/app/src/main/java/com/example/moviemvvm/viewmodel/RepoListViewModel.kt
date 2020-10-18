package com.example.moviemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviemvvm.data.model.Item
import com.example.moviemvvm.data.repository.RepoListRepository

class RepoListViewModel(val repoListRepository: RepoListRepository) : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList() {
        dataLoading.value = true
        repoListRepository.getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response?.results
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}