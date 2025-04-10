package gr.hepaestus.smartcampus.service.repositories


import gr.hepaestus.smartcampus.service.models.CourseExercise
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CourseExerciseRepository : JpaRepository<CourseExercise, UUID> {
}