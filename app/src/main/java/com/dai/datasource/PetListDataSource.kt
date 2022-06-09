package com.dai.datasource

import com.dai.petsearcher.model.Pet
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PetListDataSource {
    fun getLatestPet(){
        val uid = Firebase.auth.uid ?: ""
        val petListData = mutableListOf<Pet>()
        val querySnapShot = Firebase.firestore
    }
}