package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonBackReference
import gr.hepaestus.smartcampus.service.enums.DayOfWeek
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID


@Entity
class ScheduleEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? = null

    var dayOfWeek : DayOfWeek? = null

    var startTime: LocalTime? = null

    var endTime: LocalTime? = null





    @ManyToOne
    @JsonBackReference(value = "course_scheduleEntries")
    var course: Course? = null

    @ManyToOne
    @JsonBackReference(value = "courseExercise_scheduleEntries")
    var courseExercise: CourseExercise? = null

    @ManyToOne
    @JsonBackReference(value = "labExercise_scheduleEntries")
    var labExercise: LabExercise? = null





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
        return "ScheduleEntry(id=$id, dayOfWeek=$dayOfWeek, startTime=$startTime, endTime=$endTime, created=$created, updated=$updated)"
    }


}