package com.example.moviekotlin.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.moviekotlin.api.RetrofitClient
import com.example.moviekotlin.base.BaseViewModel
import com.example.moviekotlin.model.Movie
import kotlinx.coroutines.launch

class DetailViewModel : BaseViewModel() {
    val movie = MutableLiveData<Movie>()

    fun getMovie(id: Int) {
        uiScope.launch {
            RetrofitClient.apiService.getMovieDetail(id).let {
                if (it.isSuccessful) {
                    movie.value = it.body()
                } else {
                    Log.e("TAG", "getMovie: ERROR ${it.code()}")
                }
            }
        }
    }
}
