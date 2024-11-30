package com.arielZarate.apiFakeStore.Mapper

import com.arielZarate.apiFakeStore.dto.RatingDTO
import com.arielZarate.apiFakeStore.entity.Rating
import org.springframework.stereotype.Component


@Component
class RatingMapper:Mapper<RatingDTO,Rating> {

    // De entidad a DTO
    override fun fromEntity(entity: Rating): RatingDTO {
      return RatingDTO(
          rate =entity.rate,
          count = entity.count
      )
    }


    // De DTO a entidad
    override fun toEntity(dto: RatingDTO): Rating {
     return Rating(
         rate = dto.rate,
         count=dto.count
     )
    }


}