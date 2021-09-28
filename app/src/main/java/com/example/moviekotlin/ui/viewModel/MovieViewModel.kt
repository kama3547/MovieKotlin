package com.example.moviekotlin.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.moviekotlin.api.RetrofitClient
import com.example.moviekotlin.base.BaseViewModel
import com.example.moviekotlin.model.Movie
import kotlinx.coroutines.launch

class MovieViewModel : BaseViewModel() {
    val moviesList = MutableLiveData<List<Movie>>()

    fun getMovie() {
        uiScope.launch {
            RetrofitClient.apiService.getMovies().let {
                if (it.isSuccessful) {
                    moviesList.value = it.body()
                } else {
                    Log.e("TAG", "mov ie:Error${it.code()}")
                }
            }
        }
    }
}
