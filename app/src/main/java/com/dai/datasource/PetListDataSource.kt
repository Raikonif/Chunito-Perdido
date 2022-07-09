package com.dai.datasource

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dai.core.BaseViewHolder
import com.dai.petsearcher.latestposts.LatestPostsFragment
import com.dai.petsearcher.latestposts.adapter.LatestPostsAdapter
import com.dai.petsearcher.model.Pet
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class PetListDataSource {
    companion object {

        fun getLatestPet(rvPosts: RecyclerView)
//        : List<Pet>
        {
//            val uid = Firebase.auth.uid ?: ""
            val petListData = mutableListOf<Pet>()
            val db = Firebase.firestore
            val querySnapshot = db.collection("homePosts").get()

            querySnapshot.addOnSuccessListener { result ->
                for (pet in result) {
                    val petPost = pet.toObject(Pet::class.java)
                    petListData.add(petPost)
                    Log.d("POSTS", "Post CreatedAt: $petListData")
                }

                rvPosts.adapter = LatestPostsAdapter(petListData, 1)
                Log.d("POSTS", "$petListData")
            }
//            Log.d("POSTS", "RETURN: $petListData")
//            return petListData
        }
    }
}