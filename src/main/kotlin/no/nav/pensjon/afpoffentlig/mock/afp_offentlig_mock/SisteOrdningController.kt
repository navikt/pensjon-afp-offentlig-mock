package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hent-siste-ordning")
class SisteOrdningController {
    @PostMapping("/{tenant}/soek")
    fun soekSisteOrdning(@RequestBody soekRequest: SisteOrdningSoekRequest): SisteOrdningSoekResponse {
        return SisteOrdningSoekResponse(
            3010
        )
    }

    @PutMapping("/mock/{fnr}")
    fun mockForPerson(@PathVariable("fnr") fnr: String, @RequestBody response: SisteOrdningSoekResponse) {
    }

    @DeleteMapping("/mock/{fnr}")
    fun slettMockForPerson(@PathVariable("fnr") fnr: String) {
    }

    data class SisteOrdningSoekRequest(
        val fnr: String,
    )

    data class SisteOrdningSoekResponse(
        val tpnr: Int,
    )
}
