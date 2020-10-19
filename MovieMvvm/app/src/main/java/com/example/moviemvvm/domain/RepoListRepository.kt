package com.example.moviemvvm.domain

import androidx.lifecycle.LiveData
import com.example.moviemvvm.data.model.Item

interface RepoListRepository {
    fun loadData(): LiveData<List<Item>>
}