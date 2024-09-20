package com.jesse.c24kkgnad.g1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jesse.c24kkgnad.databinding.FragmentLayoutFrameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LayoutFrameFragment : Fragment() {
    private var _binding: FragmentLayoutFrameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLayoutFrameBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}