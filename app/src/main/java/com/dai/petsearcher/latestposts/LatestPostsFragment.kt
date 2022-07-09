package com.dai.petsearcher.latestposts

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dai.datasource.PetListDataSource
import com.dai.datasource.PetListDataSource.Companion.getLatestPet
import com.dai.datasource.PetsProvider
import com.dai.petsearcher.R
import com.dai.petsearcher.databinding.FragmentLatestPostsBinding
import com.dai.petsearcher.latestposts.adapter.LatestPostsAdapter
import com.dai.petsearcher.latestposts.viewmodel.LatestPostViewModel
import com.dai.petsearcher.latestposts.viewmodel.PostViewModel
import com.dai.petsearcher.model.Pet

class LatestPostsFragment : Fragment(R.layout.fragment_latest_posts) {

    private lateinit var binding: FragmentLatestPostsBinding
    private val viewModel: PostViewModel by activityViewModels()
    private lateinit var list: List<Pet>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLatestPostsBinding.bind(view)
        Toast.makeText(context, "Latest Posts", Toast.LENGTH_SHORT).show()

        initRecyclerView()
        initViewModel()
        binding.btnCreatePost.setOnClickListener {
            Toast.makeText(context, "Create Post", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_latestPostsFragment_to_createEditPetPostFragment)
        }
    }

    private fun initViewModel() {

    }

    private fun initRecyclerView() {
        binding.rvPetsLosts.layoutManager = LinearLayoutManager(context?.applicationContext)
        binding.rvPetsLosts.setHasFixedSize(true)
//        =LatestPostsAdapter(getLatestPet(), 1)
        getLatestPet(binding.rvPetsLosts)
    }
}
