package com.example.moviemvvm.domain

import androidx.lifecycle.LiveData
import com.example.moviemvvm.data.model.Item
import com.example.moviemvvm.data.repository.RepoListDataStore

class GetRepoListUseCase(val repoListRepository: RepoListRepository) {
    fun getRepoList(): LiveData<List<Item>> {
        return repoListRepository.loadData()
    }
}