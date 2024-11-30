package com.arielZarate.apiFakeStore.service

import com.arielZarate.apiFakeStore.Mapper.RatingMapper
import com.arielZarate.apiFakeStore.dto.ProductDTO
import com.arielZarate.apiFakeStore.entity.Product
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
    fun fetchAndReturnProducts(): Mono<List<ProductDTO>> {
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
            Mono.just(productDTOs) // Envuelve la lista en un Mono
        } else {
            // Si no hay productos, consume la API y guarda los resultados
          return  webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(ProductDTO::class.java) // Convertir la respuesta JSON en objetos ProductDTO
                .collectList() // Convertir todo en una lista
                .doOnSuccess { productDTOs ->
                    val products = productDTOs.map { dto ->
                        Product(
                            id = dto.id,
                            title = dto.title,
                            price = dto.price,
                            description = dto.description,
                            category = dto.category,
                            image = dto.image,
                            rating = ratingMapper.toEntity(dto.rating) // Mapear RatingDTO a Rating
                        )
                    }
                    saveProductsToDatabase(products) // Guardar en la base de datos
                }
                .doOnError { error ->
                    println("Error in consuming API: ${error.message}")
                }
        }
    }



    // Método privado para guardar productos en la base de datos
    private fun saveProductsToDatabase(products: List<Product>) {
        try {
          var products=  productRepository.saveAll(products)
            println("*** Products saved successfully *** ")
        } catch (ex: Exception) {
            println("Error saving products to the database: ${ex.message}")
        }
    }


}