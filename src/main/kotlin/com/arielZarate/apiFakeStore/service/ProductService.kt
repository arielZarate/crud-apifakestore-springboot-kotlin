package com.arielZarate.apiFakeStore.service

import com.arielZarate.apiFakeStore.dto.ProductDTO

interface ProductService {

    //declaramos las firmas

    fun createProduct(product:ProductDTO):ProductDTO
    fun getProducts():List<ProductDTO>
    fun getProductById(id:Long):ProductDTO
    fun updateProduct(product:ProductDTO,id:Long):ProductDTO
    fun deleteProduct(id:Long)

}