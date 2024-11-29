package com.arielZarate.fakeStoreApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FakeStoreApiApplication

fun main(args: Array<String>) {
	runApplication<FakeStoreApiApplication>(*args)
}
