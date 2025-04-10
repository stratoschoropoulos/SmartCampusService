package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.Lab
import gr.hepaestus.smartcampus.service.repositories.LabRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class LabService(
    val labRepository: LabRepository
) {

    fun getALLLabs(): MutableList<Lab> = labRepository.findAll()

    fun getLabById(id : UUID) = labRepository.findById(id)

    fun createLab(lab: Lab) = labRepository.saveAndFlush(lab)

    fun updateLab(lab: Lab) = labRepository.save(lab)

    fun deleteLabById(id: UUID) = labRepository.deleteById(id)

}