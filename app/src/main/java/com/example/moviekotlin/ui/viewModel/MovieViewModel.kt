package com.example.moviekotlin.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.moviekotlin.api.RetrofitClient
import com.example.moviekotlin.base.BaseViewModel
import com.example.moviekotlin.model.Movie
import com.example.moviekotlin.ui.repositories.RepositoryMovie
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: RepositoryMovie) : BaseViewModel() {
    val moviesList = MutableLiveData<List<Movie>>()

    fun getMovie() {
        uiScope.launch {
            repository.getMovie().let {
                if (it.isSuccessful) {
                    moviesList.value = it.body()
                } else {
                    Log.e("TAG", "movie:Error${it.code()}")
                }
            }
        }
    }
}
