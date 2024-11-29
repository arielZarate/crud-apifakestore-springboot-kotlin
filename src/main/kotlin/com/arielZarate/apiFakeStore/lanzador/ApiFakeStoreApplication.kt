package com.arielZarate.apiFakeStore.lanzador

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages =["com.arielZarate.apiFakeStore"])
class ApiFakeStoreApplication

fun main(args: Array<String>) {
	runApplication<ApiFakeStoreApplication>(*args)
}
