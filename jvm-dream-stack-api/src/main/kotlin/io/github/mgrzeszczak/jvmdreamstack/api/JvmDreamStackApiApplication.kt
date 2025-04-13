package io.github.mgrzeszczak.jvmdreamstack.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JvmDreamStackApiApplication

fun main(args: Array<String>) {
    runApplication<JvmDreamStackApiApplication>(*args)
}
