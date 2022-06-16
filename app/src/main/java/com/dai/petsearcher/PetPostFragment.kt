package com.dai.petsearcher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dai.petsearcher.databinding.FragmentPetPostBinding


class PetPostFragment : Fragment(R.layout.fragment_pet_post) {
    private lateinit var binding: FragmentPetPostBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPetPostBinding.bind(view)
    }
}