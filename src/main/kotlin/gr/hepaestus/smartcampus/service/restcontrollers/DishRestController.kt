package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.Dish
import gr.hepaestus.smartcampus.service.repositories.DishRepository
import gr.hepaestus.smartcampus.service.services.DishService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class DishRestController(
    val dishService: DishService,
    val dishRepository: DishRepository
) {

    @GetMapping(
        "/api/dish",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllDishes() : ResponseEntity<Any> =
        ResponseEntity(dishService.getAllDishes(), HttpStatus.OK)


    @GetMapping(
        "/api/dish/{dish_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getDishById(
        @PathVariable("dish_id") id : UUID
    ) : ResponseEntity<Any> {
        if (dishRepository.existsById(id)){
            return ResponseEntity(dishService.getDishById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/dish",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createDish(@RequestBody dish: Dish) : ResponseEntity<Any> =
        ResponseEntity(dishService.createDish(dish), HttpStatus.OK)


    @PutMapping(
        "/api/dish",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateDish(@RequestBody dish: Dish) : ResponseEntity<Any> {
        if (dishRepository.existsById(dish.id!!)){
            return ResponseEntity(dishService.updateDish(dish), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/dish/{dish_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteDish(
        @PathVariable("dish_id") id: UUID
    ) : ResponseEntity<Any> {
        if (dishRepository.existsById(id)){
            dishService.deleteDishById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
