package pl.cezarysanecki.blogcode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogCodeApplication

fun main(args: Array<String>) {
	runApplication<BlogCodeApplication>(*args)
}
