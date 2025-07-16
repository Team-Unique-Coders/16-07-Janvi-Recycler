package com.example.mynetworklearning.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynetworklearning.R
import com.example.mynetworklearning.ui.common.DrinkAdapter

class SlideshowFragment : Fragment() {

    private lateinit var viewModel: SlideshowViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)

        recyclerView = root.findViewById(R.id.vodkaRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[SlideshowViewModel::class.java]

        viewModel.drinksList.observe(viewLifecycleOwner) { drinks ->
            recyclerView.adapter = DrinkAdapter(drinks)
        }
    }
}
