package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.siste_ordning

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "SISTE_ORDNING")
data class SisteOrdning(
    @Id
    @Column(name = "fnr")
    val fnr: String,
    @Column(name = "tpnr")
    val tpnr: Int,
)

