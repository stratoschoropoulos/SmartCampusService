package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID


@Entity
class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? = null

    var name: String? = null

    var description: String? = null

    var photo: String? = null





    @OneToMany(mappedBy = "department", cascade = [CascadeType.ALL], targetEntity = Course::class)
    @JsonManagedReference(value = "department_courses")
    var courses: List<Course>? = mutableListOf()





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
        return "Department(id=$id, name=$name, description=$description, photo=$photo, created=$created, updated=$updated)"
    }


}