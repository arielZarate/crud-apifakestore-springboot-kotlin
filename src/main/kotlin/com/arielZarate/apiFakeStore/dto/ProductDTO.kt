package com.arielZarate.apiFakeStore.dto


class ProductDTO (
    var id: Long,//permito null pero los creo con jpa de forma identity
    var title: String,
    var price: Double,
    var description: String,
    var category: String,
    var image: String,
    var rating: RatingDTO
)


