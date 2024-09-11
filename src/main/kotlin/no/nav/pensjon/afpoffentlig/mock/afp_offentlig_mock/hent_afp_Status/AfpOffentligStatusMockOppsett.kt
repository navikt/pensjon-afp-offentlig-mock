package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.hent_afp_Status

data class AfpOffentligStatusMockOppsett(
    val direktekall: List<String>?,
    val mocksvar: List<AfpStatusResponse>?,
)
