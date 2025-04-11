package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.Course
import gr.hepaestus.smartcampus.service.repositories.CourseRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CourseService(
    val courseRepository: CourseRepository
) {

    fun getAllCourses(): MutableList<Course> = courseRepository.findAll()

    fun getCourseById(id : UUID) = courseRepository.findById(id)

    fun createCourse(course: Course) = courseRepository.saveAndFlush(course)

    fun updateCourse(course: Course) = courseRepository.save(course)

    fun deleteCourseById(id: UUID) = courseRepository.deleteById(id)

}