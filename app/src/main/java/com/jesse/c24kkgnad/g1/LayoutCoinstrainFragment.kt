package com.jesse.c24kkgnad.g1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jesse.c24kkgnad.databinding.FragmentLayoutCoinstrainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LayoutCoinstrainFragment : Fragment() {

    private var _binding: FragmentLayoutCoinstrainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLayoutCoinstrainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
