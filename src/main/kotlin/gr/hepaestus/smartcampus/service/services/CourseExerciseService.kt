package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.CourseExercise
import gr.hepaestus.smartcampus.service.repositories.CourseExerciseRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CourseExerciseService(
    val courseExerciseRepository: CourseExerciseRepository
) {

    fun getAllCourseExercises(): MutableList<CourseExercise> = courseExerciseRepository.findAll()

    fun getCourseExerciseById(id : UUID) = courseExerciseRepository.findById(id)

    fun createCourseExercise(courseExercise: CourseExercise) = courseExerciseRepository.saveAndFlush(courseExercise)

    fun updateCourseExercise(courseExercise: CourseExercise) = courseExerciseRepository.save(courseExercise)

    fun deleteCourseExerciseById(id: UUID) = courseExerciseRepository.deleteById(id)

}