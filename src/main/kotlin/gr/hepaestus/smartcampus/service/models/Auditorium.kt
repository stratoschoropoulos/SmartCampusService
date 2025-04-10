package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID


@Entity
class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? = null

    var name: String? = null

    var capacity: Int? = null

    var type: String? = null





    @ManyToOne
    @JsonBackReference(value = "lab_auditoriums")
    var lab: Lab? = null

    @OneToMany(mappedBy = "auditorium", cascade = [CascadeType.ALL], targetEntity = Course::class)
    @JsonManagedReference(value = "auditorium_courses")
    var courses: List<Course>? = mutableListOf()

    @OneToOne
    @JoinColumn(
        name = "user_id",
        nullable = false,
        unique = true
    )
    var professor: Professor? = null






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
        return "Auditorium(id=$id, name=$name, capacity=$capacity, type=$type, created=$created, updated=$updated)"
    }


}