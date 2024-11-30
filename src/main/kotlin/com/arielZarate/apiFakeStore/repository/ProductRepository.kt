package com.arielZarate.apiFakeStore.repository

import com.arielZarate.apiFakeStore.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository:JpaRepository<Product,Long>{

    //aca iran los metodos extras que necesite implementar

}