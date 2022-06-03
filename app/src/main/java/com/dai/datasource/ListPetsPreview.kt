package com.dai.datasource

import com.dai.petsearcher.model.Pet
import java.util.*

object ListPetsPreview {
    val petsList: MutableList<Pet> = mutableListOf(
        Pet(
            "1",
            mutableListOf(
                "https://www.pexels.com/photo/closeup-photo-of-brown-and-black-dog-face-406014/",
                "https://www.pexels.com/photo/closeup-photo-of-brown-and-black-dog-face-406014/",
                "https://www.pexels.com/photo/closeup-photo-of-brown-and-black-dog-face-406014/"
            ),
            "Locky",
            "Dog",
            2,
            "Male",
            Date(),
            "Lost in La Paz City",

        ),
        Pet(
            "2",
            mutableListOf(
                "https://www.pexels.com/photo/closeup-photo-of-brown-and-black-dog-face-406014/",
                "https://www.pexels.com/photo/closeup-photo-of-brown-and-black-dog-face-406014/",
                "https://www.pexels.com/photo/closeup-photo-of-brown-and-black-dog-face-406014/"
            ),
            "Rocko",
            "Dog",
            2,
            "Male",
            Date(),
            "Lost in La Paz City",
        )
    )
}