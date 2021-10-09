package com.example.moviekotlin.ui.detailFragment

import android.util.Log
import androidx.fragment.app.viewModels
import coil.load
import com.example.moviekotlin.base.BaseFragment
import com.example.moviekotlin.databinding.DetailMovieFragmentBinding
import com.example.moviekotlin.ui.adapters.MovieAdapter
import com.example.moviekotlin.ui.viewModel.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieFragment :
    BaseFragment<DetailMovieFragmentBinding>(DetailMovieFragmentBinding::inflate) {
    private val viewModel: DetailViewModel by viewModel()

    override fun setupView() {
        arguments.let {
            val id = it?.getInt("id")
            it?.getInt("id")?.let { it1 -> viewModel.getMovie(it1) }
        }
    }

    override fun initVM() {
        viewModel.movie.observe(requireActivity(), {
            binding.detailImage.load(it.image.original)
            binding.detailTxt.text = it.name
            binding.txtRating.text = it.rating.average.toString()
            binding.txtLange.text = it.language
            binding.end.text = it.ended
            binding.txtPremiered.text = it.premiered
            binding.txt.text = it.schedule.toString()
            binding.exter.text = it.externals.toString()
            binding.txtUrl.text = it.url
            binding.txtOffSite.text = it.officialSite
            binding.txtUpdate.text = it.updated.toString()
            binding.txtLinks.text = it._links.toString()
        })
    }
}