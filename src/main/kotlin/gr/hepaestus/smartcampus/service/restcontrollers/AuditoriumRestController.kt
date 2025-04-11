package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.Auditorium
import gr.hepaestus.smartcampus.service.repositories.AuditoriumRepository
import gr.hepaestus.smartcampus.service.services.AuditoriumService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class AuditoriumRestController(
    val auditoriumService: AuditoriumService,
    val auditoriumRepository: AuditoriumRepository
) {

    @GetMapping(
        "/api/auditorium",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllAuditoriums() : ResponseEntity<Any> =
        ResponseEntity(auditoriumService.getAllAuditoriums(), HttpStatus.OK)


    @GetMapping(
        "/api/auditorium/{auditorium_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAuditoriumById(
        @PathVariable("auditorium_id") id : UUID
    ) : ResponseEntity<Any> {
        if (auditoriumRepository.existsById(id)) {
            return ResponseEntity(auditoriumService.getAuditoriumById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/auditorium",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createAuditorium(@RequestBody auditorium: Auditorium) : ResponseEntity<Any> =
        ResponseEntity(auditoriumService.createAuditorium(auditorium), HttpStatus.OK)


    @PutMapping(
        "/api/auditorium",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateAuditorium(@RequestBody auditorium: Auditorium) : ResponseEntity<Any> {
        if (auditorium.id != null && auditoriumRepository.existsById(auditorium.id!!)) {
            return ResponseEntity(auditoriumService.updateAuditorium(auditorium), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/auditorium/{auditorium_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteAuditorium(
        @PathVariable("auditorium_id") id: UUID
    ) : ResponseEntity<Any> {
        if (auditoriumRepository.existsById(id)) {
            auditoriumService.deleteAuditoriumById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
