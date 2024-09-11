package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.hent_afp_Status

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/api/afp-offentlig-status")
class AfpOffentligStatusController(
    val hentAfpStatusRepository: HentAfpStatusRepository,
) {
    @GetMapping("/{tenant}/hentAfpStatus/{fnr}")
    fun hentAfpOffentligStatus(
        @PathVariable("tenant") tenant: String,
        @PathVariable("fnr") fnr: String,
        @RequestHeader("x-tpid") tpId: String,
    ): AfpStatusResponse? {
        return hentAfpStatusRepository.findById(fnr).getOrNull()?.mockOppsett?.mocksvar?.firstOrNull { it.tpId == tpId }
            ?: AfpStatusResponse(
                tpId = tpId,
                fnr = fnr,
                statusAfp = "IKKE_SOKT",
                virkningsDato = null,
                sistBenyttetG = null,
                belopsListe = null,
            )
    }
}

