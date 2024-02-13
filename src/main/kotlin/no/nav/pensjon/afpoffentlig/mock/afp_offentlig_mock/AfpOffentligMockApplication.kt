package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@SpringBootApplication
class AfpOffentligMockApplication

fun main(args: Array<String>) {
    runApplication<AfpOffentligMockApplication>(*args)
}
