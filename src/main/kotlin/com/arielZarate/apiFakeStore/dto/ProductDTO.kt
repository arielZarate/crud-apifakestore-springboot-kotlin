package com.arielZarate.apiFakeStore.dto

import com.arielZarate.apiFakeStore.entity.Rating


class ProductDTO (
    val id: Long,//permito null pero los creo con jpa de forma identity
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingDTO
)


// DTO para representar Rating de forma más sencilla
data class RatingDTO(
    val rate: Double,
    val count: Int
)