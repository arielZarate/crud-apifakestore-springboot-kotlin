package com.arielZarate.apiFakeStore.controller

import com.arielZarate.apiFakeStore.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


//constrolador de products



@RestController
@RequestMapping("/api")
class ProductController(
    private val service: ProductService
) {


  @GetMapping
  fun Welcome():String{
      return ("Welcome a la api de products de fake store api ")
  }


    //=============PRODUCTS====================================
    @GetMapping("/products")
    fun getProducts():ResponseEntity<Any>{
        return ResponseEntity.ok(service.getProducts())
    }
    @GetMapping("/products/{id}")
    fun getProductById(@PathVariable id:Long):ResponseEntity<Any>{
        val productFound=service.getProductById(id);

        return ResponseEntity.ok(productFound)
    }

    @DeleteMapping("/products/{id}")
    fun deleteProduct(@PathVariable id:Long):ResponseEntity<Any>{
        val productFound=service.deleteProduct(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}