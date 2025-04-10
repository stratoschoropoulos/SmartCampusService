package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID


@Entity
class CourseExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? = null




    @ManyToOne
    @JsonBackReference(value = "course_courseExercises")
    var course: Course? = null

    @OneToMany(mappedBy = "courseExercise", cascade = [CascadeType.ALL], targetEntity = ScheduleEntry::class)
    @JsonManagedReference(value = "courseExercise_scheduleEntries")
    var scheduleEntries: List<ScheduleEntry>? = mutableListOf()





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
        return "CourseExercise(id=$id, created=$created, updated=$updated)"
    }


}