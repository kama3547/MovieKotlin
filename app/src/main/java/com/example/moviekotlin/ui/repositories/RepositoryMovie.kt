package com.example.moviekotlin.ui.repositories

import com.example.moviekotlin.api.MovieApi

class RepositoryMovie(private val apiService: MovieApi) {
    suspend fun getMovie() = apiService.getMovies()
}