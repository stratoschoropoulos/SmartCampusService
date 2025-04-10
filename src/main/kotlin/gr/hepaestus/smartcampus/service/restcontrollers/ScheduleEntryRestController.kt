package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.ScheduleEntry
import gr.hepaestus.smartcampus.service.repositories.ScheduleEntryRepository
import gr.hepaestus.smartcampus.service.services.ScheduleEntryService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class ScheduleEntryRestController(
    val scheduleEntryService: ScheduleEntryService,
    val scheduleEntryRepository: ScheduleEntryRepository
) {

    @GetMapping(
        "/api/scheduleEntry",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllScheduleEntries() : ResponseEntity<Any> =
        ResponseEntity(scheduleEntryService.getALLScheduleEntries(), HttpStatus.OK)


    @GetMapping(
        "/api/scheduleEntry/{scheduleEntry_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getScheduleEntryById(
        @PathVariable("scheduleEntry_id") id : UUID
    ) : ResponseEntity<Any> {
        if (scheduleEntryRepository.existsById(id)){
            return ResponseEntity(scheduleEntryService.getScheduleEntryById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/scheduleEntry",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createScheduleEntry(@RequestBody scheduleEntry: ScheduleEntry) : ResponseEntity<Any> =
        ResponseEntity(scheduleEntryService.createScheduleEntry(scheduleEntry), HttpStatus.OK)


    @PutMapping(
        "/api/scheduleEntry",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateScheduleEntry(@RequestBody scheduleEntry: ScheduleEntry) : ResponseEntity<Any> {
        if (scheduleEntry.id != null && scheduleEntryRepository.existsById(scheduleEntry.id!!)){
            return ResponseEntity(scheduleEntryService.updateScheduleEntry(scheduleEntry), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/scheduleEntry/{scheduleEntry_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteScheduleEntry(
        @PathVariable("scheduleEntry_id") id: UUID
    ) : ResponseEntity<Any> {
        if (scheduleEntryRepository.existsById(id)){
            scheduleEntryService.deleteScheduleEntryById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
