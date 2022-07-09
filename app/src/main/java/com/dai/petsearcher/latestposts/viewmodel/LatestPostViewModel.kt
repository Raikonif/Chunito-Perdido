package com.dai.petsearcher.latestposts.viewmodel

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dai.datasource.PetListDataSource
import com.dai.petsearcher.model.Pet

class LatestPostViewModel : ViewModel() {


    private val petVariables = MutableLiveData<Pet>()

    private val _idPet = MutableLiveData<String>()
    val idPet: LiveData<String>
        get() = _idPet

    private val _petName = MutableLiveData<String>()
    val petName: LiveData<String>
        get() = _petName

    private val _photoPet = MutableLiveData<String>()
    val photoPet: LiveData<String>
        get() = _photoPet

    private val _petType = MutableLiveData<String>()
    val petType: LiveData<String>
        get() = _petType

    private val _petAge = MutableLiveData<Int>()
    val petAge: LiveData<Int>
        get() = _petAge

    private val _petGender = MutableLiveData<String>()
    val petGender: LiveData<String>
        get() = _petGender

    private val _petLostDate = MutableLiveData<String>()
    val petLostDate: LiveData<String>
        get() = _petLostDate

    private val _petDescription = MutableLiveData<String>()
    val petDescription: LiveData<String>
        get() = _petDescription


    fun setPetLost(petItem: Pet) {
        petVariables.value = petItem
    }

    fun getPetLost(): LiveData<Pet>{
        return petVariables
    }
    fun getPetModel(){
//        val latestPetPosts = PetListDataSource.getLatestPet()
//        petVariables.postValue(latestPetPosts)
    }

}

