package com.dai.petsearcher.latestposts

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dai.datasource.PetsProvider
import com.dai.petsearcher.R
import com.dai.petsearcher.databinding.FragmentLatestPostsBinding
import com.dai.petsearcher.latestposts.adapter.LatestPostsAdapter
import com.dai.petsearcher.latestposts.viewmodel.LatestPostViewModel
import com.dai.petsearcher.model.Pet

class LatestPostsFragment : Fragment(R.layout.fragment_latest_posts) {

    private lateinit var binding: FragmentLatestPostsBinding
    private val viewModel: LatestPostViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLatestPostsBinding.bind(view)
        Toast.makeText(context, "Latest Posts", Toast.LENGTH_SHORT).show()

        initRecyclerView()
    }
    private fun initRecyclerView(){
        binding.rvPetsLosts.layoutManager = LinearLayoutManager(context?.applicationContext)
        binding.rvPetsLosts.setHasFixedSize(true)
        binding.rvPetsLosts.adapter = LatestPostsAdapter(PetsProvider.petsList, 1)
    }
}
