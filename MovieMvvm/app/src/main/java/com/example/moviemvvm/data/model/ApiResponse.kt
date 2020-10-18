package com.example.moviemvvm.data.model

data class MovieResponse(
    val results: List<Item>
)

data class Item(
    var id: Int,
    var populatiry: Double,
    var vote_count: Int,
    var title: String,
    var vote_average: String,
    var poster_path: String,
    var release_date: String,
    var popularity: String,
    var budget: Int,
    var overview: String

)