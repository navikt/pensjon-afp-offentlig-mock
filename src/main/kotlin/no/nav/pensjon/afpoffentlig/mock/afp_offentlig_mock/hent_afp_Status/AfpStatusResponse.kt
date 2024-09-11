package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.hent_afp_Status

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

/**
 * Responseobjekt slik det er definert i
 *
 * "Dokumentasjon av API-tjenester i overføringsavtalen"
 */
data class AfpStatusResponse(
    val tpId: String?,
    val fnr: String?,
    val statusAfp: String?,
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Oslo") val virkningsDato: LocalDate?,
    val sistBenyttetG: Int?,
    val belopsListe: List<BelopDato>?,
) {
    data class BelopDato(
        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Oslo")
        val fomDato: LocalDate,
        val belop: Int,
    )
}
