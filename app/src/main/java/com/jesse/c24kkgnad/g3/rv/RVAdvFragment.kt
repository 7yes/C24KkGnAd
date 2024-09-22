package com.jesse.c24kkgnad.g3.rv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jesse.c24kkgnad.R
import com.jesse.c24kkgnad.databinding.FragmentRVAdvBinding
import com.jesse.c24kkgnad.databinding.ItemSuperheroBinding
import com.jesse.c24kkgnad.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RVAdvFragment : Fragment() {

    private var _binding: FragmentRVAdvBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRVAdvBinding.inflate(layoutInflater, container, false)
        initRecyclerView()
        return binding.root
    }


    private fun initRecyclerView() {
        val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        val adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList) {
            Toast.makeText(requireContext(), it.superHero, Toast.LENGTH_SHORT).show()
        }
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapter
        binding.rv.addItemDecoration(decoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

//Adapter
class SuperHeroAdapter(
    private val superHeroList: List<SuperHero>,
    private val listener: (SuperHero) -> Unit
) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun getItemCount(): Int = superHeroList.size

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(superHeroList[position], listener)
    }
}

//ViewHolder
class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superHero: SuperHero, listener: (SuperHero) -> Unit) {
        binding.apply {
            imSuperhero.load(superHero.photo)
            tvSuperhero.text = superHero.superHero
            tvRealName.text = superHero.realName
            tvPublisher.text = superHero.publisher
            root.setOnClickListener {
                listener(superHero)
            }
        }
    }
}

//Data Class
data class SuperHero(
    val superHero: String, val publisher: String, val realName: String, val photo: String
)

//Provider
class SuperHeroProvider {
    companion object {
        val superHeroList = listOf(
            SuperHero(
                "Daredevil",
                "Marvel",
                "Matthew Michael Murdock",
                "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"
            ),
            SuperHero(
                "Wolverine",
                "Marvel",
                "James Howlett",
                "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"
            ),
            SuperHero(
                "Batman",
                "DC",
                "Bruce Wayne",
                "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"
            ),
            SuperHero(
                "Thor",
                "Marvel",
                "Thor Odinson",
                "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"
            ),
            SuperHero(
                "Flash",
                "DC",
                "Jay Garrick",
                "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"
            ),
            SuperHero(
                "Green Lantern",
                "DC",
                "Alan Scott",
                "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"
            ),
            SuperHero(
                "Wonder Woman",
                "DC",
                "Princess Diana",
                "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"
            )
        )
    }
}