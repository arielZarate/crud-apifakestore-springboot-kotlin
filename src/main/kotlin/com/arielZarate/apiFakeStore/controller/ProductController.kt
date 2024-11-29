package com.arielZarate.apiFakeStore.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


//constrolador de products



@RestController
@RequestMapping("/api")
class ProductController {


  @GetMapping
  fun Welcome():String{
      return ("Welcome a la api de products de fake store api ")
  }


    //=============PRODUCTS====================================



}