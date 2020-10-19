package com.example.moviemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviemvvm.data.model.Item
import com.example.moviemvvm.data.repository.RepoListRepository
import com.example.moviemvvm.domain.GetRepoListUseCase

class RepoListViewModel(val getRepoListUseCase: GetRepoListUseCase) : BaseViewModel() {
//    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList(): LiveData<List<Item>> {
        return getRepoListUseCase.getRepoList()
//        dataLoading.value = true
//        getRepoListUseCase.getRepoList { isSuccess, response ->
//            dataLoading.value = false
//            if (isSuccess) {
//                repoListLive.value = response?.items
//                empty.value = false
//            } else {
//                empty.value = true
//            }
//        }
    }
}
