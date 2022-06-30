package com.dai.datasource

import com.dai.petsearcher.model.Pet
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PetListDataSource {
    companion object {
        fun getLatestPet(): List<Pet> {
//            val uid = Firebase.auth.uid ?: ""
            val petListData = mutableListOf<Pet>()
            val db = Firebase.firestore
            val querySnapshot = db.collection("homePosts").get()

            querySnapshot.addOnSuccessListener { result ->
                for (pet in result) {
                    pet.toObject(Pet::class.java).let { petPost ->
                        petListData.add(petPost)
                    }
                }
            }
            return petListData
        }
    }
}