package com.arielZarate.apiFakeStore.entity

import jakarta.persistence.*


@Entity
@Table(name="product")
data class Product(

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,//permito null pero los creo con jpa de forma identity
    val title: String,
    val price: Double,
    @Column(length = 10000)
    val description: String,
    val category: String,
    val image: String,

    @Embedded
    val rating: Rating

) {


    // Constructor sin parámetros (requiere ser explícito en Kotlin, porque data class genera constructores)
    constructor() : this(null, "", 0.0, "", "", "", Rating())

}