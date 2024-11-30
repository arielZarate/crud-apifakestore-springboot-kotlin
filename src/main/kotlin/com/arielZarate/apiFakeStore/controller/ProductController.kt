package com.arielZarate.apiFakeStore.controller

import com.arielZarate.apiFakeStore.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
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

  @GetMapping("/products")
  fun getProducts():ResponseEntity<Any>{
      return ResponseEntity.ok(service.getProducts())
  }


    //=============PRODUCTS====================================



}