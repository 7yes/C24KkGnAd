package com.jesse.c24kkgnad.g3.mvvm.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jesse.c24kkgnad.databinding.FragmentMVVMBinding
import com.jesse.c24kkgnad.g3.mvvm.model.QuoteProvider
import com.jesse.c24kkgnad.g3.mvvm.viewmodel.QuoteVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MVVMFragment : Fragment() {
    private var _binding: FragmentMVVMBinding? = null
    private val binding get() = _binding!!
    private val viewModel: QuoteVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMVVMBinding.inflate(layoutInflater, container, false)
        viewModel.quoteModel.observe(viewLifecycleOwner) {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        }
        binding.fragmentContainer.setOnClickListener {
            viewModel.randomQuote()
        }
        viewModel.randomQuote()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val quoP = QuoteProvider()
        Log.d("TAG", "onViewCreated: ${quoP.randomQuote} ")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
