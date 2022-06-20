package com.dai

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.dai.petsearcher.R
import com.dai.petsearcher.databinding.FragmentCreateEditPetPostBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import java.util.*

class CreateEditPetPostFragment : Fragment(R.layout.fragment_create_edit_pet_post) {

    private lateinit var binding: FragmentCreateEditPetPostBinding
    private var bitmap: Bitmap? = null
    private val auth: FirebaseAuth by lazy { Firebase.auth }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateEditPetPostBinding.bind(view)
        binding.ivPhotoInfo.setOnClickListener {
            Toast.makeText(context, "Please select a photo", Toast.LENGTH_SHORT).show()
        }
        createLostPet()
    }

    private fun createLostPet() {
        val context = requireContext()
        val user = auth.currentUser
        val randomName = UUID.randomUUID().toString()
        val imageRef = Firebase.storage.reference.child("images/petLost/${user?.uid}/$randomName")
        val baos = ByteArrayOutputStream()
        bitmap?.let { it.compress(Bitmap.CompressFormat.JPEG,100, baos) }
        val downLoadUrl = imageRef.putBytes(baos.toByteArray()).snapshot.storage.downloadUrl.toString()

        val petName = binding.etNameInfo.text.toString()
        val petAge = binding.etAgeInfo.text.toString().toInt()
        val petType = binding.etTypeInfo.text.toString()
        val petIdOwner = auth.currentUser?.uid
        val petGender = binding.etGenderInfo.text.toString()
        val petLostDate = binding.etDateInfo.toString()
        val petDescription = binding.etDescriptionInfo.text.toString()
        val petFounded = false


        binding.btnUpload.setOnClickListener {
            //TODO: upload to firebase, image must be updated
        }
    }
}