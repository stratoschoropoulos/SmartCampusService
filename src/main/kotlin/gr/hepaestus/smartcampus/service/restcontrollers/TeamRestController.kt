package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.Team
import gr.hepaestus.smartcampus.service.repositories.TeamRepository
import gr.hepaestus.smartcampus.service.services.TeamService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class TeamRestController(
    val teamService: TeamService,
    val teamRepository: TeamRepository
) {

    @GetMapping(
        "/api/team",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllTeams() : ResponseEntity<Any> =
        ResponseEntity(teamService.getAllTeams(), HttpStatus.OK)


    @GetMapping(
        "/api/team/{team_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getTeamById(
        @PathVariable("team_id") id : UUID
    ) : ResponseEntity<Any> {
        if (teamRepository.existsById(id)){
            return ResponseEntity(teamService.getTeamById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/team",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createTeam(@RequestBody team: Team) : ResponseEntity<Any> =
        ResponseEntity(teamService.createTeam(team), HttpStatus.OK)


    @PutMapping(
        "/api/team",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateTeam(@RequestBody team: Team) : ResponseEntity<Any> {
        if (team.id != null && teamRepository.existsById(team.id!!)){
            return ResponseEntity(teamService.updateTeam(team), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/team/{team_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTeam(
        @PathVariable("team_id") id: UUID
    ) : ResponseEntity<Any> {
        if (teamRepository.existsById(id)){
            teamService.deleteTeamById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
