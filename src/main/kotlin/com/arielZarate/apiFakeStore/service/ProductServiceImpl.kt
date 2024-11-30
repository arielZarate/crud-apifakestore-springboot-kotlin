package com.arielZarate.apiFakeStore.service

import com.arielZarate.apiFakeStore.dto.ProductDTO
import com.arielZarate.apiFakeStore.exception.CustomException
import com.arielZarate.apiFakeStore.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val serviceApi:ApiService
) :ProductService {




    /*
    *
     // Método para guardar productos en la base de datos
    private fun saveProductsToDatabase(productDTOs: List<ProductDTO>) {
        val products = productDTOs.map { dto ->
            Product(
                id = dto.id,
                title = dto.title,
                price = dto.price,
                description = dto.description,
                category = dto.category,
                image = dto.image,
                rating = ratingMapper.toEntity(dto.rating) // Mapeo del RatingDTO a Rating
            )
        }

        try {
            productRepository.saveAll(products)
            println("*** Products saved successfully ***")
        } catch (ex: Exception) {
            println("Error saving products to the database: ${ex.message}")
        }
    }
    * */


    override fun createProduct(product: ProductDTO): ProductDTO {
        TODO("Not yet imp")
    }

    override fun getProducts(): List<ProductDTO> {
    try {
        return serviceApi.fetchAndReturnProducts()
    }catch ( ex:Exception){
        throw CustomException("Error el devolver datos de la api ${ex.message}" )
    }

    }

    override fun getProductById(id: Long): ProductDTO {
        TODO("Not yet implemented")
    }

    override fun updateProduct(product: ProductDTO, id: Long): ProductDTO {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: Long) {
        TODO("Not yet implemented")
    }
}