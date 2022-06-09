package com.dai.petsearcher.latestposts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dai.petsearcher.R
import com.dai.petsearcher.databinding.FragmentLatestPostDetailBinding


class LatestPostDetailFragment : Fragment(R.layout.fragment_latest_post_detail) {
   private val binding: FragmentLatestPostDetailBinding by lazy {
        FragmentLatestPostDetailBinding.bind(
            requireView())
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root
    }
}