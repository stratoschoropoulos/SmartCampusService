package gr.hepaestus.smartcampus.service.restcontrollers

import gr.hepaestus.smartcampus.service.models.Department
import gr.hepaestus.smartcampus.service.repositories.DepartmentRepository
import gr.hepaestus.smartcampus.service.services.DepartmentService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class DepartmentRestController(
    val departmentService: DepartmentService,
    val departmentRepository: DepartmentRepository
) {

    @GetMapping(
        "/api/department",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllDepartments() : ResponseEntity<Any> =
        ResponseEntity(departmentService.getAllDepartments(), HttpStatus.OK)


    @GetMapping(
        "/api/department/{department_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getDepartmentById(
        @PathVariable("department_id") id : UUID
    ) : ResponseEntity<Any> {
        if (departmentRepository.existsById(id)) {
            return ResponseEntity(departmentService.getDepartmentById(id), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @PostMapping(
        "/api/department",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createDepartment(@RequestBody department: Department) : ResponseEntity<Any> =
        ResponseEntity(departmentService.createDepartment(department), HttpStatus.OK)


    @PutMapping(
        "/api/department",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateDepartment(@RequestBody department: Department) : ResponseEntity<Any> {
        if (department.id != null && departmentRepository.existsById(department.id!!)) {
            return ResponseEntity(departmentService.updateDepartment(department), HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }


    @DeleteMapping(
        "/api/department/{department_id}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteDepartment(
        @PathVariable("department_id") id: UUID
    ) : ResponseEntity<Any> {
        if (departmentRepository.existsById(id)) {
            departmentService.deleteDepartmentById(id)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

}
