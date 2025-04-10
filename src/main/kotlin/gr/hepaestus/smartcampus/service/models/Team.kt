package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID


@Entity
class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? = null





    @ManyToOne
    @JsonBackReference(value = "lab_teams")
    var lab: Lab? = null

    @OneToMany(mappedBy = "team", cascade = [CascadeType.ALL], targetEntity = LabExercise::class)
    @JsonManagedReference(value = "team_labExercises")
    var labExercises: List<LabExercise>? = mutableListOf()





    var created : LocalDateTime? = null

    var updated : LocalDateTime? = null

    @PrePersist
    fun prePersist() {
        created = LocalDateTime.now()
        updated = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updated = LocalDateTime.now()
    }

    override fun toString(): String {
        return "Team(id=$id, created=$created, updated=$updated)"
    }


}