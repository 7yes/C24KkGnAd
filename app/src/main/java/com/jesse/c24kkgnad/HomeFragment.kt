package com.jesse.c24kkgnad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jesse.c24kkgnad.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lyoFrame.apply {
            val font = ResourcesCompat.getFont(requireContext(), R.font.fascinate_inline_regular)
            typeface = font
        }
            .setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_layoutFrameFragment) }
        binding.lyoLinear.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_layoutLInearFragment) }
        binding.lyoConstrain.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_layoutCoinstrainFragment) }
        binding.dayPicker.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_dayPickerFragment) }
        binding.timePicker.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_timePickerFragment) }
        binding.perritos.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_perritosFragment) }
        binding.mvvm0.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_MVVMFragment) }
        binding.chips.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_chipsFragment) }
        binding.rv.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_RVAdvFragment) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
