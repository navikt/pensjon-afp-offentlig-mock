package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.hent_afp_Status

import org.springframework.data.jpa.repository.JpaRepository


interface HentAfpStatusRepository : JpaRepository<HentAfpStatus, HentAfpStatusId>
