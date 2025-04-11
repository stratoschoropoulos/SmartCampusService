package gr.hepaestus.smartcampus.service.models

import com.fasterxml.jackson.annotation.JsonBackReference
import gr.hepaestus.smartcampus.service.enums.DishType
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID


@Entity
class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : UUID? =null

    var name: String? = null

    var dishType: DishType? = null

    @ManyToOne
    @JsonBackReference(value = "dish_meals")
    var dish: Dish? = null


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
        return "Meal(id=$id, name=$name, dishType=$dishType, created=$created, updated=$updated)"
    }


}