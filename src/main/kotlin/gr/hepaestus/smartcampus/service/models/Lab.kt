package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID


@Entity
class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? = null

    var description: String? = null

    var photo: String? = null




    @ManyToOne
    @JsonBackReference(value = "course_labs")
    var course: Course? = null

    @OneToMany(mappedBy = "lab", cascade = [CascadeType.ALL], targetEntity = Auditorium::class)
    @JsonManagedReference(value = "lab_auditoriums")
    var auditoriums: List<Auditorium>? = mutableListOf()

    @OneToMany(mappedBy = "lab", cascade = [CascadeType.ALL], targetEntity = Team::class)
    @JsonManagedReference(value = "lab_teams")
    var teams: List<Team>? = mutableListOf()





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
        return "Lab(id=$id, description=$description, photo=$photo, created=$created, updated=$updated)"
    }


}