package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.hent_afp_Status

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "HENT_AFP_STATUS")
data class HentAfpStatus(
    @EmbeddedId
    val hentAfpStatusId: HentAfpStatusId,

    @Column(name = "retur_fnr")
    val fnr: String?,
    @Column(name = "tpid")
    val tpId: String?,
    @Column(name = "status_afp")
    val statusAfp: String?,
    @Column(name = "virkningsdato")
    val virkningsdato: LocalDate?,
    @Column(name = "belop")
    val belop: Int?,
    @Column(name = "dato_sist_regulert")
    val datoSistRegulert: LocalDate?,
)
