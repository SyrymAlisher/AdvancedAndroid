package com.example.moviemvvm.data.repository

import com.example.moviemvvm.data.api.ApiClient
import com.example.moviemvvm.data.model.MovieResponse
import com.example.moviemvvm.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoListRepository {

    // GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: MovieResponse?) -> Unit) {

        ApiClient.instance.getPopularMovieList(Constants.MovieDBApiKey).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {
                if (response != null && response.isSuccessful) {
                    onResult(true, response.body()!!)
                } else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: RepoListRepository? = null
        fun getInstance() = INSTANCE
            ?: RepoListRepository().also {
                INSTANCE = it
            }
    }
}