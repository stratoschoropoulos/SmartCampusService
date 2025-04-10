package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? = null

    var name: String? = null

    var code: String? = null

    var description: String? = null





    @OneToMany(mappedBy = "course", cascade = [CascadeType.ALL], targetEntity = Lab::class)
    @JsonManagedReference(value = "course_labs")
    var labs: List<Lab>? = mutableListOf()

    @OneToMany(mappedBy = "course", cascade = [CascadeType.ALL], targetEntity = CourseExercise::class)
    @JsonManagedReference(value = "course_courseExercises")
    var courseExercises: List<CourseExercise>? = mutableListOf()

    @OneToMany(mappedBy = "course", cascade = [CascadeType.ALL], targetEntity = ScheduleEntry::class)
    @JsonManagedReference(value = "course_scheduleEntries")
    var scheduleEntries: List<ScheduleEntry>? = mutableListOf()

    @ManyToOne
    @JsonBackReference(value = "auditorium_courses")
    var auditorium: Auditorium? = null

    @ManyToOne
    @JsonBackReference(value = "department_courses")
    var department: Department? = null






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
        return "Course(id=$id, name=$name, code=$code, description=$description, created=$created, updated=$updated)"
    }


}