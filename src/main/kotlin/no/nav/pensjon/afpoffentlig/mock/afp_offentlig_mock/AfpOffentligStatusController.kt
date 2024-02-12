package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.Month
import java.time.temporal.TemporalAdjuster
import java.time.temporal.TemporalAdjusters

@RestController
@RequestMapping("/api/apf-offentlig-status")
class AfpOffentligStatusController {
    @PostMapping("/hent")
    fun hentAfpOffentligStatus(@RequestBody request: HentStatusRequest): InnvilgetDto {
        return InnvilgetDto(
            belop = 50_000,
            tpNummer = 3010,
            startdato = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()),
            sluttdato = null,
            sistRegulert = LocalDate.now().minusYears(1).with(Month.MAY).withDayOfMonth(1),
        )
    }

    @PutMapping("/mock/{fnr}")
    fun mockForPerson(@PathVariable("fnr") fnr: String, @RequestBody statusResponse: HentStatusResponse) {

    }

    @DeleteMapping("/mock/{fnr}")
    fun slettMockForPerson(@PathVariable("fnr") fnr: String) {
    }

    data class HentStatusRequest(
        val fnr: String,
        val onsketVirkningtidspunkt: LocalDate,
        val hjemmel: String,
        val tema: String,
        val type: String,
    )

    data class HentStatusResponse(
        val innvilget: InnvilgetDto?,
        val soknad: SoknadDto?,
        val manglendeApi: ManglendeApiDto?,
    )

    data class InnvilgetDto(
        val belop: Int,
        val tpNummer: Int,
        val startdato: LocalDate,
        val sluttdato: LocalDate?,
        val sistRegulert: LocalDate,
    )

    data class SoknadDto(
        val onsketVirkningsdato: LocalDate,
    )

    data class ManglendeApiDto(
        val onsketVirkningsdato: LocalDate
    )
}
