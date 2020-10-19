package com.example.moviemvvm.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviemvvm.data.api.ApiService
import com.example.moviemvvm.data.model.MovieResponse
import com.example.moviemvvm.data.model.Item
import retrofit2.HttpException
import retrofit2.Response
import kotlinx.coroutines.*
import timber.log.Timber

abstract class BaseDataStore(@PublishedApi internal val service: ApiService) {

    abstract fun loadData(): LiveData<List<Item>>


    inline fun fetchData(crossinline call: (ApiService) -> Deferred<Response<MovieResponse>>): LiveData<List<Item>> {
        val result = MutableLiveData<List<Item>>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = call(service)
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        result.value = response.body()?.results
                    } else {
                        Timber.d("Error occurred with code ${response.code()}")
                    }
                } catch (e: HttpException) {
                    Timber.d("Error: ${e.message()}")
                } catch (e: Throwable) {
                    Timber.d("Error: ${e.message}")
                }
            }
        }

        return result
    }


}