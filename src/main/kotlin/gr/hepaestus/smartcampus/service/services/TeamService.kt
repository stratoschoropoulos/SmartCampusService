package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.Team
import gr.hepaestus.smartcampus.service.repositories.TeamRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TeamService(
    val teamRepository: TeamRepository
) {

    fun getALLTeams(): MutableList<Team> = teamRepository.findAll()

    fun getTeamById(id : UUID) = teamRepository.findById(id)

    fun createTeam(team: Team) = teamRepository.saveAndFlush(team)

    fun updateTeam(team: Team) = teamRepository.save(team)

    fun deleteTeamById(id: UUID) = teamRepository.deleteById(id)

}