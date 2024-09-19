package com.jesse.c24kkgnad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jesse.c24kkgnad.databinding.FragmentLayoutLInearBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LayoutLInearFragment : Fragment() {
    private var _binding: FragmentLayoutLInearBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLayoutLInearBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}