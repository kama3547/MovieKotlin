package com.example.moviekotlin.utils.modules

import com.example.moviekotlin.api.RetrofitClient
import com.example.moviekotlin.ui.repositories.RepositoryDetail
import com.example.moviekotlin.ui.repositories.RepositoryMovie
import com.example.moviekotlin.ui.viewModel.DetailViewModel
import com.example.moviekotlin.ui.viewModel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
val networkModule = module {
    single { RetrofitClient }
    single { get<RetrofitClient>().apiService }
}
val repositoryMovie = module {
    factory { RepositoryMovie(get()) }
    factory { RepositoryDetail(get()) }
}