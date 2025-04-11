package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.Lab
import gr.hepaestus.smartcampus.service.repositories.LabRepository
import gr.hepaestus.smartcampus.service.services.LabService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class LabRestController(
    val labService: LabService,
    val labRepository: LabRepository
) {

    @GetMapping(
        "/api/lab",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllLabs() : ResponseEntity<Any> =
        ResponseEntity(labService.getAllLabs(), HttpStatus.OK)


    @GetMapping(
        "/api/lab/{lab_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getLabById(
        @PathVariable("lab_id") id : UUID
    ) : ResponseEntity<Any> {
        if (labRepository.existsById(id)){
            return ResponseEntity(labService.getLabById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/lab",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createLab(@RequestBody lab: Lab) : ResponseEntity<Any> =
        ResponseEntity(labService.createLab(lab), HttpStatus.OK)


    @PutMapping(
        "/api/lab",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateLab(@RequestBody lab: Lab) : ResponseEntity<Any> {
        if (labRepository.existsById(lab.id!!)){
            return ResponseEntity(labService.updateLab(lab), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/lab/{lab_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteLab(
        @PathVariable("lab_id") id: UUID
    ) : ResponseEntity<Any> {
        if (labRepository.existsById(id)){
            labService.deleteLabById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
