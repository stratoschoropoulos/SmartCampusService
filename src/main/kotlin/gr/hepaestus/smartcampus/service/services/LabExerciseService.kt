package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.LabExercise
import gr.hepaestus.smartcampus.service.repositories.LabExerciseRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class LabExerciseService(
    val labExerciseRepository: LabExerciseRepository
) {

    fun getALLLabExercises(): MutableList<LabExercise> = labExerciseRepository.findAll()

    fun getLabExerciseById(id : UUID) = labExerciseRepository.findById(id)

    fun createLabExercise(labExercise: LabExercise) = labExerciseRepository.saveAndFlush(labExercise)

    fun updateLabExercise(labExercise: LabExercise) = labExerciseRepository.save(labExercise)

    fun deleteLabExerciseById(id: UUID) = labExerciseRepository.deleteById(id)

}