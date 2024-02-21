package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.Month
import java.time.temporal.TemporalAdjuster
import java.time.temporal.TemporalAdjusters

@RestController
@RequestMapping("/api/afp-offentlig-status")
class AfpOffentligStatusController {
    @GetMapping("/{tenant}/hentAfpStatus/{fnr}")
    fun hentAfpOffentligStatus(@PathVariable("fnr") fnr: String): HentAfpStatusResponse {
        return HentAfpStatusResponse(
            fnr = fnr,
            belop = 50_000,
            tpId = "3010",
            statusAfp = "INNVILGET",
            virkningsdato = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()),
            datoSistRegulert = LocalDate.now().minusYears(1).with(Month.MAY).withDayOfMonth(1),
        )
    }

    @PutMapping("/mock/{fnr}")
    fun mockForPerson(@PathVariable("fnr") fnr: String, @RequestBody statusResponse: HentAfpStatusResponse) {

    }

    @DeleteMapping("/mock/{fnr}")
    fun slettMockForPerson(@PathVariable("fnr") fnr: String) {
    }
    data class HentAfpStatusResponse(
        val tpId: String,
        val fnr: String,
        val statusAfp: String,
        val virkningsdato: LocalDate,
        val belop: Int,
        val datoSistRegulert: LocalDate,
    )
}
