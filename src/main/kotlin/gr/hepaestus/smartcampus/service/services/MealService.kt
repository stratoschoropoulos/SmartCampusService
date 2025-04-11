package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.Meal
import gr.hepaestus.smartcampus.service.repositories.MealRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MealService(
    val mealRepository: MealRepository
) {

    fun getAllMeals(): MutableList<Meal> = mealRepository.findAll()

    fun getMealById(id : UUID) = mealRepository.findById(id)

    fun createMeal(meal: Meal) = mealRepository.saveAndFlush(meal)

    fun updateMeal(meal: Meal) = mealRepository.save(meal)

    fun deleteMealById(id: UUID) = mealRepository.deleteById(id)

}