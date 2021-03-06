package com.dai.petsearcher.model

import android.location.Location
import com.google.firebase.Timestamp
import java.sql.Time

import java.util.*

data class Pet(
    val idOwner: String ?= "",
    var photo: String ?= "",
    var name: String ?= "",
    var type: String ?= "",
    var age: Int ?= 0,
    var gender: String ?= "Male",
//    var lostDate: String ?=  "",
    var description: String ?= "",
    var founded: Boolean ?= false,
    val createdAt: Timestamp ?= Timestamp.now(),
//    var location: Location
)