package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.hent_afp_Status

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "PERSON_MOCK_OPPSETT")
data class PersonMockOppsett(
    @Id
    val fnr: String,
    @Column(name = "mock_oppsett")
    @JdbcTypeCode(SqlTypes.JSON)
    val mockOppsett: AfpOffentligStatusMockOppsett,
)
