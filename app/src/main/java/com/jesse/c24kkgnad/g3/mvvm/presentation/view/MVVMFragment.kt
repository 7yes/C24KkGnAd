package com.jesse.c24kkgnad.g3.mvvm.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jesse.c24kkgnad.databinding.FragmentMVVMBinding
import com.jesse.c24kkgnad.g3.mvvm.presentation.viewmodel.QuoteVM
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
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressCircular.visibility = if (it) View.VISIBLE else View.GONE
        }
        binding.fragmentContainer.setOnClickListener {
            viewModel.randomQuote()
        }
        viewModel.onCreate()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val quoP = QuoteProvider()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
