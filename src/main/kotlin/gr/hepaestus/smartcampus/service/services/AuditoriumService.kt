package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.Auditorium
import gr.hepaestus.smartcampus.service.repositories.AuditoriumRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AuditoriumService(
    val auditoriumRepository: AuditoriumRepository
) {

    fun getAllAuditoriums(): MutableList<Auditorium> = auditoriumRepository.findAll()

    fun getAuditoriumById(id : UUID) = auditoriumRepository.findById(id)

    fun createAuditorium(auditorium: Auditorium) = auditoriumRepository.saveAndFlush(auditorium)

    fun updateAuditorium(auditorium: Auditorium) = auditoriumRepository.save(auditorium)

    fun deleteAuditoriumById(id: UUID) = auditoriumRepository.deleteById(id)

}