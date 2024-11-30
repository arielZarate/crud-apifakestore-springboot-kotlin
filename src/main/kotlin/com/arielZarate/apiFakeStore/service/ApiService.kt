package com.arielZarate.apiFakeStore.service

import com.arielZarate.apiFakeStore.Mapper.RatingMapper
import com.arielZarate.apiFakeStore.dto.ProductDTO
import com.arielZarate.apiFakeStore.entity.Product
import com.arielZarate.apiFakeStore.exception.CustomException
import com.arielZarate.apiFakeStore.repository.ProductRepository
import org.springframework.stereotype.Service

//dependencia para consumir la api con metodo http
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


@Service
class ApiService(
    private val webClient:WebClient,
    private val productRepository:ProductRepository,
    private val ratingMapper: RatingMapper
) {

    //obtener todos los products de la api
    // Obtener todos los productos



    // Obtener todos los productos de la API o la base de datos
    fun fetchAndReturnProducts(): List<ProductDTO> {
        // Buscamos productos en la base de datos
        val existingProducts = productRepository.findAll()

        return if (existingProducts.isNotEmpty()) {
            // Si hay productos en la base de datos, los convertimos en DTOs y los devolvemos
            val productDTOs = existingProducts.map { product ->
                ProductDTO(
                    id = product.id as Long,
                    title = product.title,
                    price = product.price,
                    description = product.description,
                    category = product.category,
                    image = product.image,
                    rating = ratingMapper.fromEntity(product.rating)
                )
            }
            println("******************Datos recuperados con exito *******************")
            productDTOs // Devolvemos la lista directamente (no envuelta en Mono)
        } else {
            // Si no hay productos en la base de datos, consumimos la API
            val productDTOs = webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(ProductDTO::class.java) // Convertir la respuesta JSON en objetos ProductDTO
                .collectList()
                .block() // Usamos block() para esperar que la respuesta sea devuelta

            // Si se obtuvieron productos de la API, los guardamos en la base de datos
            if (productDTOs != null) {
                val products = productDTOs.map { dto ->
                    Product(
                        id = dto.id,
                        title = dto.title,
                        price = dto.price,
                        description = dto.description,
                        category = dto.category,
                        image = dto.image,
                        rating = ratingMapper.toEntity(dto.rating)
                    )
                }
                saveProductsToDatabase(products) // Guardamos en la base de datos
            }

            productDTOs ?: emptyList() // Devuelve una lista vacía si no se obtienen productos
        }
    }
    // Método privado para guardar productos en la base de datos
    private fun saveProductsToDatabase(products: List<Product>) {
        try {
           productRepository.saveAll(products)
            println("*** Products saved successfully *** ")
        } catch (ex: Exception) {
            println("Error saving products to the database: ${ex.message}")
            throw  CustomException("Error saving products to the database: ${ex.message}")
        }
    }


}