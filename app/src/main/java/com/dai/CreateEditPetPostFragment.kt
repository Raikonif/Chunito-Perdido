package com.dai

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.dai.petsearcher.R
import com.dai.petsearcher.databinding.FragmentCreateEditPetPostBinding
import com.dai.petsearcher.model.Pet
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import java.util.*

class CreateEditPetPostFragment : Fragment(R.layout.fragment_create_edit_pet_post) {

    private lateinit var binding: FragmentCreateEditPetPostBinding
    private val auth: FirebaseAuth by lazy { Firebase.auth }
    private var selectedPhotoUri: Uri? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateEditPetPostBinding.bind(view)

        binding.ivPhotoInfo.setOnClickListener {
            Toast.makeText(context, "Please select a photo", Toast.LENGTH_SHORT).show()
            selectPhoto()
        }
        binding.btnUpload.setOnClickListener {
            Toast.makeText(context, "Information Uploaded", Toast.LENGTH_SHORT).show()
            uploadInfoToFirebase()
        }
    }

    private fun createLostPet(downloadUrl: String) {
        val user = auth.currentUser
//        val imageRef = Firebase.storage.reference.child("images/petLost/${user?.uid}/$randomName")
//        val baos = ByteArrayOutputStream()
//        bitmap?.let { it.compress(Bitmap.CompressFormat.JPEG, 100, baos) }
//        val downLoadUrl = imageRef.putBytes(baos.toByteArray()).snapshot.storage.downloadUrl.toString()
        val petName = binding.etNameInfo.text.toString()
        val petAge = binding.etAgeInfo.text.toString().toInt()
        val petType = binding.etTypeInfo.text.toString()
        val petIdOwner = auth.currentUser!!.uid
        val petGender = binding.etGenderInfo.text.toString()
        val petLostDate = "13:45 15/07/2022"
        val petDescription = binding.etDescriptionInfo.text.toString()
        val petFounded = false

        val petWithVariables = Pet(
            petIdOwner,
            downloadUrl,
            petName,
            petType,
            petAge,
            petGender,
//          petLostDate,
            petDescription,
            petFounded,
            Timestamp.now()
        )

        if (theModelIsNotEmpty(
                petIdOwner,
                downloadUrl,
                petName,
                petType,
                petAge,
                petGender,
                petDescription
            )
        ) {
            //TODO: upload to firebase, image must be updated
            user?.let {
                it.displayName?.let {
                    Firebase.firestore.collection("homePosts")
                        .add(
                            petWithVariables
                        )
                }
            }
            updateToMyOwnPosts(petWithVariables)

        } else {
            Toast.makeText(
                requireContext(),
                "Need Fill All the Spaces for upload the information",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun updateToMyOwnPosts(pet: Pet) {
        auth.currentUser?.displayName.let {
            Firebase.firestore.collection("ownPosts")
                .document(auth.currentUser!!.uid).collection("myPetLost").add(pet)
        }

    }

    private fun theModelIsNotEmpty(
        idOwner: String,
        downloadUrl: String,
        name: String,
        type: String,
        age: Int,
        gender: String,
        description: String,
    ): Boolean {
        return (idOwner.isNotEmpty() && downloadUrl.isNotEmpty() && name.isNotEmpty() && type.isNotEmpty() && age.toString()
            .isNotEmpty() && gender.isNotEmpty() && description.isNotEmpty())
    }

    private fun selectPhoto() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            // proceed and check what the selected image was....
            Log.d(TAG, "Photo was selected")
            selectedPhotoUri = data.data
//            binding.ivPhotoInfo.setImageBitmap(imageBitmap)
            binding.ivPhotoInfo.setImageURI(selectedPhotoUri)
        }
    }

    private fun uploadInfoToFirebase() {
        uploadPhotoToFirebaseStorage()
    }

    private fun uploadPhotoToFirebaseStorage() {
        if (selectedPhotoUri == null) return
        val randomName = UUID.randomUUID().toString()
        val uid = auth.currentUser?.uid
        val storageRef = Firebase.storage.reference.child("images/petLost/$uid/$randomName")
//        val baos = ByteArrayOutputStream()
//        val data = baos.toByteArray()
//        selectedPhotoUri!!.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val uploadTask = storageRef.putFile(selectedPhotoUri!!)
        val downloadUrl =
            storageRef.putFile(selectedPhotoUri!!).snapshot.storage.downloadUrl.toString()
        uploadTask.addOnSuccessListener { task ->
            Log.d(TAG, "Image uploaded successfully!!: ${task.metadata?.path}")

            storageRef.downloadUrl.addOnSuccessListener { uri ->
                Log.d(TAG, "Image URL downloaded Successfully")
                createLostPet(uri.toString())
                return@addOnSuccessListener
            }
        }.addOnFailureListener {
            Toast.makeText(
                requireContext(),
                "Not Uploaded",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}