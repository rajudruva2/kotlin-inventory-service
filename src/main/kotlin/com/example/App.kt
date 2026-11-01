package com.example
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
@SpringBootApplication class App
fun main(args: Array<String>) { runApplication<App>(*args) }
@RestController class Api {
 @GetMapping("/") fun home() = mapOf("service" to "inventory-service", "status" to "running")
 @GetMapping("/health") fun health() = mapOf("status" to "UP")
 @GetMapping("/api/inventory") fun api() = listOf(mapOf("sku" to "SKU-001", "quantity" to 25), mapOf("sku" to "SKU-002", "quantity" to 10))
}
