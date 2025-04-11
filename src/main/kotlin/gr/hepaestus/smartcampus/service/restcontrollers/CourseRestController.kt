package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.Course
import gr.hepaestus.smartcampus.service.repositories.CourseRepository
import gr.hepaestus.smartcampus.service.services.CourseService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class CourseRestController(
    val courseService: CourseService,
    val courseRepository: CourseRepository
) {

    @GetMapping(
        "/api/course",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllCourses() : ResponseEntity<Any> =
        ResponseEntity(courseService.getAllCourses(), HttpStatus.OK)


    @GetMapping(
        "/api/course/{course_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getCourseById(
        @PathVariable("course_id") id : UUID
    ) : ResponseEntity<Any> {
        if (courseRepository.existsById(id)) {
            return ResponseEntity(courseService.getCourseById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/course",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createCourse(@RequestBody course: Course) : ResponseEntity<Any> =
        ResponseEntity(courseService.createCourse(course), HttpStatus.OK)


    @PutMapping(
        "/api/course",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateCourse(@RequestBody course: Course) : ResponseEntity<Any> {
        if (course.id != null && courseRepository.existsById(course.id!!)) {
            return ResponseEntity(courseService.updateCourse(course), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/course/{course_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteCourse(
        @PathVariable("course_id") id: UUID
    ) : ResponseEntity<Any> {
        if (courseRepository.existsById(id)) {
            courseService.deleteCourseById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
