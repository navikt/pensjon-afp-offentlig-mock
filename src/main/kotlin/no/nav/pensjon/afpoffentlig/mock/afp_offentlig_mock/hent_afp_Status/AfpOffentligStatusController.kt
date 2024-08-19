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
    @GetMapping("/tenants")
    fun tenants(): TenantsResponse = TenantsResponse(
        tenants = listOf(
            Tenant(
                id = "gabler",
                name = "Gabler",
            ),
            Tenant(
                id = "klp",
                name = "KLP",
            ),
            Tenant(
                id = "mpk",
                name = "Maritim Pensjonskasse",
            ),
            Tenant(
                id = "opf",
                name = "Oslo Pensjonsforsikring",
            ),
            Tenant(
                id = "spk",
                name = "Statens pensjonskasse",
            ),
            Tenant(
                id = "storebrand",
                name = "Storebrand",
            ),
        )
    )

    @GetMapping("/{tenant}/hentAfpStatus/{fnr}")
    fun hentAfpOffentligStatus(
        @PathVariable("tenant") tenant: String,
        @PathVariable("fnr") fnr: String
    ): HentAfpStatusDTO? {
        return hentAfpStatusRepository.findById(fnr).getOrNull()?.data?.firstOrNull { it.ordning == tenant }?.let {
            HentAfpStatusDTO(
                fnr = fnr,
                tpId = it.tpId,
                statusAfp = it.statusAfp,
                virkningsdato = it.virkningsdato,
                belop = it.belop,
                datoSistRegulert = it.datoSistRegulert
            )
        }
    }

    @GetMapping("/{fnr}")
    fun hentMockForPerson(
        @PathVariable("tenant") tenant: String,
        @PathVariable("fnr") fnr: String
    ): Mock? {
        return hentAfpStatusRepository.findById(fnr).getOrNull()
    }

    @PutMapping("/{fnr}")
    fun lagreMockForPerson(
        @PathVariable("tenant") tenant: String,
        @PathVariable("fnr") fnr: String,
        @RequestBody status: Mock
    ) {
        hentAfpStatusRepository.deleteById(fnr)
        hentAfpStatusRepository.save(status)
    }

    @DeleteMapping("/{fnr}")
    fun slettMockForPerson(@PathVariable("tenant") tenant: String, @PathVariable("fnr") fnr: String) {
        hentAfpStatusRepository.deleteById(fnr)
    }

    data class HentAfpStatusDTO(
        val fnr: String?,
        val tpId: String?,
        val statusAfp: String?,
        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Oslo")
        val virkningsdato: LocalDate?,
        val belop: Int?,
        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Oslo")
        val datoSistRegulert: LocalDate?,
    )

    data class Mockdata(
        val ordning: String,
        val tpId: String?,
        val statusAfp: String?,
        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Oslo")
        val virkningsdato: LocalDate?,
        val belop: Int?,
        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Oslo")
        val datoSistRegulert: LocalDate?,
    )

    data class Mock(
        val data: List<Mockdata>,
    )

    data class Tenant(
        val id: String,
        val name: String,
    )

    data class TenantsResponse(
        val tenants: List<Tenant>
    )
}

