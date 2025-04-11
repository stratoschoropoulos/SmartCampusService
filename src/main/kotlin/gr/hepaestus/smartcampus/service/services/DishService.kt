package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.Dish
import gr.hepaestus.smartcampus.service.repositories.DishRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DishService(
    val dishRepository: DishRepository
) {

    fun getAllDishes(): MutableList<Dish> = dishRepository.findAll()

    fun getDishById(id : UUID) = dishRepository.findById(id)

    fun createDish(dish: Dish) = dishRepository.saveAndFlush(dish)

    fun updateDish(dish: Dish) = dishRepository.save(dish)

    fun deleteDishById(id: UUID) = dishRepository.deleteById(id)

}