package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.Professor
import gr.hepaestus.smartcampus.service.repositories.ProfessorRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProfessorService(
    val professorRepository: ProfessorRepository
) {

    fun getAllProfessors(): MutableList<Professor> = professorRepository.findAll()

    fun getProfessorById(id : UUID) = professorRepository.findById(id)

    fun createProfessor(professor: Professor) = professorRepository.saveAndFlush(professor)

    fun updateProfessor(professor: Professor) = professorRepository.save(professor)

    fun deleteProfessorById(id: UUID) = professorRepository.deleteById(id)

}