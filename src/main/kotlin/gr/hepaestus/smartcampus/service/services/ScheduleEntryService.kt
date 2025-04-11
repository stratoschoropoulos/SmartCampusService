package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.ScheduleEntry
import gr.hepaestus.smartcampus.service.repositories.ScheduleEntryRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ScheduleEntryService(
    val scheduleEntryRepository: ScheduleEntryRepository
) {

    fun getAllScheduleEntries(): MutableList<ScheduleEntry> = scheduleEntryRepository.findAll()

    fun getScheduleEntryById(id : UUID) = scheduleEntryRepository.findById(id)

    fun createScheduleEntry(scheduleEntry: ScheduleEntry) = scheduleEntryRepository.saveAndFlush(scheduleEntry)

    fun updateScheduleEntry(scheduleEntry: ScheduleEntry) = scheduleEntryRepository.save(scheduleEntry)

    fun deleteScheduleEntryById(id: UUID) = scheduleEntryRepository.deleteById(id)

}