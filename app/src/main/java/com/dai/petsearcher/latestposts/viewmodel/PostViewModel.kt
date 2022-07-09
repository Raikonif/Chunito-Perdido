package com.dai.petsearcher.latestposts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dai.petsearcher.model.Pet

class PostViewModel: ViewModel() {
    val petPosts: MutableLiveData<List<Pet>> by lazy {
        MutableLiveData<List<Pet>>().also{

            loadPosts()
        }
    }
    private fun getPosts(): LiveData<List<Pet>>{

        return petPosts
    }
    private fun loadPosts() {
        TODO("Not yet implemented")
    }
}