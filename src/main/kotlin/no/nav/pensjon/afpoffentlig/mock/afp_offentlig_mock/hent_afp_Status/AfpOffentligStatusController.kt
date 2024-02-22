package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.hent_afp_Status

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/api/afp-offentlig-status")
class AfpOffentligStatusController(
    val hentAfpStatusRepository: HentAfpStatusRepository,
) {
    @GetMapping("/{tenant}/hentAfpStatus/{fnr}")
    fun hentAfpOffentligStatus(@PathVariable("tenant") tenant: String, @PathVariable("fnr") fnr: String): HentAfpStatusDTO? {
        return hentAfpStatusRepository.findById(HentAfpStatusId(tenant, fnr)).getOrNull()?.run {
            HentAfpStatusDTO(
                fnr = fnr,
                tpId = tpId,
                statusAfp = statusAfp,
                virkningsdato = virkningsdato,
                belop = belop,
                datoSistRegulert = datoSistRegulert
            )
        }
    }

    @PutMapping("/{tenant}/mock/{fnr}")
    fun mockForPerson(@PathVariable("tenant") tenant: String, @PathVariable("fnr") fnr: String, @RequestBody status: HentAfpStatusDTO) {
        hentAfpStatusRepository.deleteById(HentAfpStatusId(tenant, fnr))
        hentAfpStatusRepository.save(HentAfpStatus(
            hentAfpStatusId = HentAfpStatusId(
                tenant = tenant,
                fnr = fnr
            ),
            tpId = status.tpId,
            fnr = status.fnr,
            statusAfp = status.statusAfp,
            virkningsdato = status.virkningsdato,
            belop = status.belop,
            datoSistRegulert = status.datoSistRegulert,
        ))
    }

    @DeleteMapping("/{tenant}/mock/{fnr}")
    fun slettMockForPerson(@PathVariable("tenant") tenant: String, @PathVariable("fnr") fnr: String) {
        hentAfpStatusRepository.deleteById(HentAfpStatusId(tenant, fnr))
    }

    data class HentAfpStatusDTO(
        val fnr: String?,
        val tpId: String?,
        val statusAfp: String?,
        @JsonFormat(pattern="yyyy-MM-dd", timezone = "Europe/Oslo")
        val virkningsdato: LocalDate?,
        val belop: Int?,
        @JsonFormat(pattern="yyyy-MM-dd", timezone = "Europe/Oslo")
        val datoSistRegulert: LocalDate?,
    )
}
