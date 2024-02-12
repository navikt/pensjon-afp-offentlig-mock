package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/hent-siste-ordning")
class SisteOrdningController {
    @PostMapping("/soek")
    fun soekSisteOrdning(@RequestBody soekRequest: SisteOrdningSoekRequest): SisteOrdningSoekResponse {
        return SisteOrdningSoekResponse(
            3010
        )
    }

    data class SisteOrdningSoekRequest(
        val fnr: String,
    )

    data class SisteOrdningSoekResponse(
        val tpnr: Int,
    )
}
