package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.siste_ordning

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hent-siste-ordning")
class SisteOrdningController(
    val sisteOrdningRepository: SisteOrdningRepository,
) {
    @PostMapping("/{tenant}/soek")
    fun soekSisteOrdning(@RequestBody soekRequest: SisteOrdningSoekRequest): ResponseEntity<SisteOrdningSoekResponse> {
        return ResponseEntity.of(sisteOrdningRepository.findById(soekRequest.fnr).map { SisteOrdningSoekResponse(tpnr = it.tpnr) })
    }

    @PutMapping("/mock/{fnr}")
    fun mockForPerson(@PathVariable("fnr") fnr: String, @RequestBody response: SisteOrdningSoekResponse) {
        sisteOrdningRepository.deleteById(fnr)
        sisteOrdningRepository.save(SisteOrdning(fnr, response.tpnr))
    }

    @DeleteMapping("/mock/{fnr}")
    fun slettMockForPerson(@PathVariable("fnr") fnr: String) {
        sisteOrdningRepository.deleteById(fnr)
    }

    data class SisteOrdningSoekRequest(
        val fnr: String,
    )

    data class SisteOrdningSoekResponse(
        val tpnr: Int,
    )
}
