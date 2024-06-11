package pl.cezarysanecki.blogcode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class BlogCodeApplication

fun main(args: Array<String>) {
  runApplication<BlogCodeApplication>(*args)
}
