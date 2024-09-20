package com.jesse.c24kkgnad.g2.perritos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jesse.c24kkgnad.databinding.FragmentPerritosBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

@AndroidEntryPoint
class PerritosFragment : Fragment() {

    private var _binding: FragmentPerritosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerritosBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        searchByName("hound")
    }

    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(PerritosAPI::class.java).getDogsByBreed("$query/images")
            val puppies = call.body()
            Log.d("TAG", "searchByName: $call")
            Log.d("TAG", "searchByName: $puppies")
            if (call.isSuccessful) {
                val images = puppies?.images ?: emptyList()
                Log.d("TAG", "searchByName: $images")
                // binding.rvDogs.adapter = PerritosAdapter(images)
            } else {
                // showError()
            }
        }
    }
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    interface PerritosAPI {
        @GET
        suspend fun getDogsByBreed(@Url url: String): Response<ResponseDogs>
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

