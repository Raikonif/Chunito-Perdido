package com.dai.petsearcher.model

import android.location.Location
import java.util.*

data class Pet(
    var id: String,
    var photo: String,
    var name: String,
    var type: String,
    var age: Int,
    var gender: String = "Male",
    var lostDate: Date = Date(),
    var description: String,
    var founded: Boolean = false
//    var location: Location
)