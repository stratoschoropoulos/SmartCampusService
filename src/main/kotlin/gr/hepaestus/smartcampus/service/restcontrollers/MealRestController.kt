package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.Meal
import gr.hepaestus.smartcampus.service.repositories.MealRepository
import gr.hepaestus.smartcampus.service.services.MealService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class MealRestController(
    val mealService: MealService,
    val mealRepository: MealRepository
) {

    @GetMapping(
        "/api/meal",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllMeals() : ResponseEntity<Any> =
        ResponseEntity(mealService.getAllMeals(), HttpStatus.OK)


    @GetMapping(
        "/api/meal/{meal_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getMealById(
        @PathVariable("meal_id") id : UUID
    ) : ResponseEntity<Any> {
        if (mealRepository.existsById(id)){
            return ResponseEntity(mealService.getMealById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/meal",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createMeal(@RequestBody meal: Meal) : ResponseEntity<Any> =
        ResponseEntity(mealService.createMeal(meal), HttpStatus.OK)


    @PutMapping(
        "/api/meal",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateMeal(@RequestBody meal: Meal) : ResponseEntity<Any> {
        if (mealRepository.existsById(meal.id!!)){
            return ResponseEntity(mealService.updateMeal(meal), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/meal/{meal_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteMeal(
        @PathVariable("meal_id") id: UUID
    ) : ResponseEntity<Any> {
        if (mealRepository.existsById(id)){
            mealService.deleteMealById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
