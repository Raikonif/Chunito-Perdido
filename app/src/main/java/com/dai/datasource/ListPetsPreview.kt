package com.dai.datasource

import com.dai.petsearcher.model.Pet
import java.util.*

class PetsProvider {
    companion object {
        val petsList: MutableList<Pet> = mutableListOf(
            Pet(
                "1",
                "https://4.bp.blogspot.com/-zxjt8q4xy0E/T5gCTTVgkTI/AAAAAAAAAAM/OawriTmOv_I/s320/perritos.jpg",
                "Locky",
                "Dog",
                2,
                "Male",
                "Lost in La Paz City",
                false,


                ),
            Pet(
                "2",
                "https://images.pexels.com/photos/406014/pexels-photo-406014.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "Rocko",
                "Dog",
                2,
                "Male",
                "Lost in La Paz City",
                false
            )
        )
    }
}