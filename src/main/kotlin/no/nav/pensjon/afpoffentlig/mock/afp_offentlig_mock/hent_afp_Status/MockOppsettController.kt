package no.nav.pensjon.afpoffentlig.mock.afp_offentlig_mock.hent_afp_Status

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/api/mock-oppsett")
class MockOppsettController(
    val hentAfpStatusRepository: HentAfpStatusRepository,
) {
    @GetMapping("/{fnr}")
    fun hentMockForPerson(@PathVariable("fnr") fnr: String): ResponseEntity<AfpOffentligStatusMockOppsett?> {
        return ResponseEntity.ofNullable(hentAfpStatusRepository.findById(fnr).getOrNull()?.mockOppsett)
    }

    @PutMapping("/{fnr}")
    fun lagreMockForPerson(
        @PathVariable("fnr") fnr: String,
        @RequestBody status: AfpOffentligStatusMockOppsett
    ) {
        hentAfpStatusRepository.deleteById(fnr)
        hentAfpStatusRepository.save(PersonMockOppsett(fnr, status))
    }

    @DeleteMapping("/{fnr}")
    fun slettMockForPerson(@PathVariable("fnr") fnr: String) {
        hentAfpStatusRepository.deleteById(fnr)
    }

    @GetMapping("/muligedirektekall")
    fun muligDirekteTpId(): MuligeDirektekallResponse {
        return MuligeDirektekallResponse(
            muligeDirekteKall = emptyList()
        )
    }

    data class MuligeDirektekallResponse(
        val muligeDirekteKall: List<String>
    )
}

