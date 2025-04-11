package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.CourseExercise
import gr.hepaestus.smartcampus.service.repositories.CourseExerciseRepository
import gr.hepaestus.smartcampus.service.services.CourseExerciseService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class CourseExerciseRestController(
    val courseExerciseService: CourseExerciseService,
    val courseExerciseRepository: CourseExerciseRepository
) {

    @GetMapping(
        "/api/courseExercise",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllCourseExercises() : ResponseEntity<Any> =
        ResponseEntity(courseExerciseService.getAllCourseExercises(), HttpStatus.OK)


    @GetMapping(
        "/api/courseExercise/{courseExercise_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getCourseExerciseById(
        @PathVariable("courseExercise_id") id : UUID
    ) : ResponseEntity<Any> {
        if (courseExerciseRepository.existsById(id)) {
            return ResponseEntity(courseExerciseService.getCourseExerciseById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/courseExercise",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createCourseExercise(@RequestBody courseExercise: CourseExercise) : ResponseEntity<Any> =
        ResponseEntity(courseExerciseService.createCourseExercise(courseExercise), HttpStatus.OK)


    @PutMapping(
        "/api/courseExercise",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateCourseExercise(@RequestBody courseExercise: CourseExercise) : ResponseEntity<Any> {
        if (courseExercise.id != null && courseExerciseRepository.existsById(courseExercise.id!!)) {
            return ResponseEntity(courseExerciseService.updateCourseExercise(courseExercise), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/courseExercise/{courseExercise_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteCourseExercise(
        @PathVariable("courseExercise_id") id: UUID
    ) : ResponseEntity<Any> {
        if (courseExerciseRepository.existsById(id)) {
            courseExerciseService.deleteCourseExerciseById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
