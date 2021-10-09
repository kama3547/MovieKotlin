package com.example.moviekotlin.ui.repositories

import com.example.moviekotlin.api.MovieApi

class RepositoryDetail (private val apiService: MovieApi) {
    suspend fun getMovie(id: Int) = apiService.getMovieDetail(id)
}