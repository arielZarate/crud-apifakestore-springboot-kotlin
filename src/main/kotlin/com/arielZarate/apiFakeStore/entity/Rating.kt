package com.arielZarate.apiFakeStore.entity

import jakarta.persistence.Embeddable


/*

@Embeddable: La anotación en la clase Rating indica
 que esta clase puede ser embebida dentro de otra entidad (Product),
 es decir, no tiene una tabla separada en la base de datos.
@Embedded: En Product, la propiedad rating se embebe como parte de la tabla de product.
*/

@Embeddable
class Rating(
    val rate:Double=0.0,
    val count:Int=0
) {

    // Constructor sin parámetros (requiere ser explícito en Kotlin, porque data class genera constructores)
    constructor() : this(0.0, 0)
}