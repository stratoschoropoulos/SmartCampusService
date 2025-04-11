package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import gr.hepaestus.smartcampus.service.enums.DayOfWeek
import gr.hepaestus.smartcampus.service.enums.MealType
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID


@Entity
class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? = null

    var mealType: MealType? = null

    var day: DayOfWeek? = null

    @OneToMany(mappedBy = "dish", cascade = [CascadeType.ALL], targetEntity = Meal::class)
    @JsonManagedReference(value = "dish_meals")
    var meals: List<Meal>? = mutableListOf()



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
        return "Dish(id=$id, mealType=$mealType, day=$day, created=$created, updated=$updated)"
    }


}