package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AfpOffentligMockApplication

fun main(args: Array<String>) {
	runApplication<AfpOffentligMockApplication>(*args)
}
