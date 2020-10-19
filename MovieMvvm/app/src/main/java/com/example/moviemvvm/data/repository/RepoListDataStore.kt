package com.example.moviemvvm.data.repository

import androidx.lifecycle.LiveData
import com.example.moviemvvm.data.api.ApiService
import com.example.moviemvvm.data.model.Item
import com.example.moviemvvm.domain.RepoListRepository
import com.example.moviemvvm.utils.Constants


class RepoListDataStore(apiService: ApiService) : RepoListRepository, BaseDataStore(apiService) {

    override fun loadData(): LiveData<List<Item>> {
        return fetchData { service.getPopularMovieList(Constants.MovieDBApiKey) }
    }
}