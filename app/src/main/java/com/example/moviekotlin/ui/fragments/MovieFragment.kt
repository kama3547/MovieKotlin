package com.example.moviekotlin.ui.fragments


import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviekotlin.R
import com.example.moviekotlin.base.BaseFragment
import com.example.moviekotlin.databinding.FragmentMovieBinding
import com.example.moviekotlin.ui.adapters.MovieAdapter
import com.example.moviekotlin.ui.networkCheck.NetworkConnection
import com.example.moviekotlin.ui.viewModel.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieFragment : BaseFragment<FragmentMovieBinding>(FragmentMovieBinding::inflate) {
    private val viewModel: MovieViewModel by viewModel()

    override fun initVM() {
        NetworkConnection(requireActivity().application).observe(viewLifecycleOwner, { connect ->
            if (connect) {
                viewModel.getMovie()
                viewModel.moviesList.observe(this) {
                    binding.movieRv.apply {
                        adapter = MovieAdapter(it, this@MovieFragment::openDetailMovie)
                        layoutManager = GridLayoutManager(requireContext(), 2)
                    }
                }
            } else {
                findNavController().navigate(R.id.fragmentCheckInternet)
            }
        })
    }

    private fun openDetailMovie(id: Int) {
        val bundle = bundleOf("id" to id)
        view?.findNavController()?.navigate(R.id.detailMovieFragment, bundle)
    }
}