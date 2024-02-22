package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.hent_afp_Status

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class HentAfpStatusId(
    @Column(name = "tenant")
    val tenant: String,
    @Column(name = "fnr")
    val fnr: String,
) : Serializable
