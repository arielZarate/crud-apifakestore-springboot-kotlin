package com.arielZarate.apiFakeStore.Mapper

import com.arielZarate.apiFakeStore.dto.ProductDTO
import com.arielZarate.apiFakeStore.dto.RatingDTO
import com.arielZarate.apiFakeStore.entity.Product
import org.springframework.stereotype.Component


@Component
class ProductMapper(
    private val ratingMapper:RatingMapper
): Mapper<ProductDTO, Product> {



    //de producto a dto
    override fun fromEntity(entity: Product): ProductDTO {
       return ProductDTO(
           id=entity.id?:0L,
           title=entity.title,
           price=entity.price,
           description=entity.description,
           category=entity.category,
           image=entity.image,
           rating=ratingMapper.fromEntity(entity.rating)
           )
    }


    override fun toEntity(dto: ProductDTO): Product {
        return Product(
            id = dto.id,
            title = dto.title,
            price = dto.price,
            description = dto.description,
            category = dto.category,
            image=dto.image,
            rating = ratingMapper.toEntity(dto.rating)
        )

    }

}