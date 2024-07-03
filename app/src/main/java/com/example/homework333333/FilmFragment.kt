package com.example.homework333333

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework333333.databinding.FragmentFilmBinding
import com.squareup.picasso.Picasso

class FilmFragment : Fragment(R.layout.fragment_film) {
    private var binding: FragmentFilmBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilmBinding.bind(view)
        val filmName = arguments?.getString(ARG_FILM_NAME) ?: "ERROR"
        val year = arguments?.getString(ARG_YEAR) ?: "ERROR"
        val description = arguments?.getString(ARG_DESCRIPTION) ?: "ERROR"
        val imageUrl = arguments?.getString(ARG_IMAGE_URL) ?: "ERROR"
        binding?.run {
            detailFilmTitle.text = filmName
            detailYearTitle.text = year
            detailDescription.text = description
            Picasso.get().load(imageUrl).into(detailFilmImage)

        }
        val button = binding?.tobackButton
        button?.setOnClickListener {
            findNavController().navigate(R.id.firstFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_FILM_NAME = "FILM"
        private const val ARG_YEAR = "YEAR"
        private const val ARG_IMAGE_URL = "IMAGE"
        private const val ARG_DESCRIPTION = "DESCRIPTION"
        fun bundle(
            filmName: String,
            year: String,
            imageUrl: String,
            description: String
        ): Bundle = Bundle().apply {
            putString(ARG_FILM_NAME, filmName)
            putString(ARG_YEAR, year)
            putString(ARG_DESCRIPTION, description)
            putString(ARG_IMAGE_URL, imageUrl)
        }
    }
}