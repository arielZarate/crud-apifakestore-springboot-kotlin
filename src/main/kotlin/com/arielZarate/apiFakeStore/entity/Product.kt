package com.arielZarate.apiFakeStore.entity

import jakarta.persistence.*


@Entity
@Table(name="product")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,//permito null pero los creo con jpa de forma identity
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,

    @Embedded
    val rating: Rating

) {




}