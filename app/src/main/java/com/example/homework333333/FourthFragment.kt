package com.example.homework333333

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework333333.databinding.FragmentFirstBinding
import com.example.homework333333.databinding.FragmentFourthBinding

class FourthFragment : Fragment(R.layout.fragment_fourth) {
    private var binding: FragmentFourthBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFourthBinding.bind(view)

        binding.run {  }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}