package com.arielZarate.apiFakeStore

import com.arielZarate.apiFakeStore.service.ApiService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication//(scanBasePackages =["com.arielZarate.apiFakeStore"])
class ApiFakeStoreApplication {

	@Bean
	fun runServiceApi(apiService: ApiService) = CommandLineRunner {
		apiService.fetchAndReturnProducts();
	}
}
fun main(args: Array<String>) {
	runApplication<ApiFakeStoreApplication>(*args)
}
