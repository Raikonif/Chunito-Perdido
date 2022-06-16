package com.dai

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dai.petsearcher.R
import com.dai.petsearcher.databinding.FragmentCreateEditPetPostBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreateEditPetPostFragment : Fragment(R.layout.fragment_create_edit_pet_post) {

    private lateinit var binding: FragmentCreateEditPetPostBinding

    private val auth: FirebaseAuth by lazy { Firebase.auth }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateEditPetPostBinding.bind(view)

        createLostPet()
    }

    private fun createLostPet() {
        val context = requireContext()
        binding.btnUpload.setOnClickListener {
            val petName = binding.etNameInfo.text.toString()
            val petAge = binding.etAgeInfo.text.toString().toInt()
            binding.ivPhotoInfo.setOnClickListener {

            }
        }
    }
}