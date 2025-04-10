package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.LabExercise
import gr.hepaestus.smartcampus.service.repositories.LabExerciseRepository
import gr.hepaestus.smartcampus.service.services.LabExerciseService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class LabExerciseRestController(
    val labExerciseService: LabExerciseService,
    val labExerciseRepository: LabExerciseRepository
) {

    @GetMapping(
        "/api/labExercise",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllLabExercises() : ResponseEntity<Any> =
        ResponseEntity(labExerciseService.getALLLabExercises(), HttpStatus.OK)


    @GetMapping(
        "/api/labExercise/{labExercise_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getLabExerciseById(
        @PathVariable("labExercise_id") id : UUID
    ) : ResponseEntity<Any> {
        if (labExerciseRepository.existsById(id)){
            return ResponseEntity(labExerciseService.getLabExerciseById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/labExercise",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createLabExercise(@RequestBody labExercise: LabExercise) : ResponseEntity<Any> =
        ResponseEntity(labExerciseService.createLabExercise(labExercise), HttpStatus.OK)


    @PutMapping(
        "/api/labExercise",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateLabExercise(@RequestBody labExercise: LabExercise) : ResponseEntity<Any> {
        if (labExercise.id != null && labExerciseRepository.existsById(labExercise.id!!)){
            return ResponseEntity(labExerciseService.updateLabExercise(labExercise), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/labExercise/{labExercise_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteLabExercise(
        @PathVariable("labExercise_id") id: UUID
    ) : ResponseEntity<Any> {
        if (labExerciseRepository.existsById(id)){
            labExerciseService.deleteLabExerciseById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
