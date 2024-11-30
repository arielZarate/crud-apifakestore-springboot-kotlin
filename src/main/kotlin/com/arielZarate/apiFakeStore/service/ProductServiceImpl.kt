package com.arielZarate.apiFakeStore.service

import com.arielZarate.apiFakeStore.Mapper.ProductMapper
import com.arielZarate.apiFakeStore.dto.ProductDTO
import com.arielZarate.apiFakeStore.entity.Product
import com.arielZarate.apiFakeStore.exception.CustomException
import com.arielZarate.apiFakeStore.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val serviceApi:ApiService,
    private val productMapper: ProductMapper
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
        } catch (ex: Exception) {
            throw CustomException("Error in Api:  ${ex.message}")
        }

    }

    override fun getProductById(id: Long): ProductDTO {
      val product=productRepository.findById(id).orElseThrow{
          CustomException("product by Id:${id} not found ")
      }

        return productMapper.fromEntity(product);
    }

    override fun updateProduct(product: ProductDTO, id: Long): ProductDTO {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: Long) {

       if(!productRepository.existsById(id))
       {
           throw CustomException("Product not found by id $id")
       }

        return productRepository.deleteById(id);
    }
}