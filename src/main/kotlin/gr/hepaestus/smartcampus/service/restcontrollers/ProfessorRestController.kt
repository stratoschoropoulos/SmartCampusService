package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.Professor
import gr.hepaestus.smartcampus.service.repositories.ProfessorRepository
import gr.hepaestus.smartcampus.service.services.ProfessorService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class ProfessorRestController(
    val professorService: ProfessorService,
    val professorRepository: ProfessorRepository
) {

    @GetMapping(
        "/api/professor",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllProfessors() : ResponseEntity<Any> =
        ResponseEntity(professorService.getALLProfessors(), HttpStatus.OK)


    @GetMapping(
        "/api/professor/{professor_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getProfessorById(
        @PathVariable("professor_id") id : UUID
    ) : ResponseEntity<Any> {
        if (professorRepository.existsById(id)){
            return ResponseEntity(professorService.getProfessorById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/professor",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createProfessor(@RequestBody professor: Professor) : ResponseEntity<Any> =
        ResponseEntity(professorService.createProfessor(professor), HttpStatus.OK)


    @PutMapping(
        "/api/professor",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateProfessor(@RequestBody professor: Professor) : ResponseEntity<Any> {
        if (professor.id != null && professorRepository.existsById(professor.id!!)){
            return ResponseEntity(professorService.updateProfessor(professor), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/professor/{professor_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteProfessor(
        @PathVariable("professor_id") id: UUID
    ) : ResponseEntity<Any> {
        if (professorRepository.existsById(id)){
            professorService.deleteProfessorById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
