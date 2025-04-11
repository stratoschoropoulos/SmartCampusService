package gr.hepaestus.smartcampus.service.services

import gr.hepaestus.smartcampus.service.models.Department
import gr.hepaestus.smartcampus.service.repositories.DepartmentRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DepartmentService(
    val departmentRepository: DepartmentRepository
) {

    fun getAllDepartments(): MutableList<Department> = departmentRepository.findAll()

    fun getDepartmentById(id : UUID) = departmentRepository.findById(id)

    fun createDepartment(department: Department) = departmentRepository.saveAndFlush(department)

    fun updateDepartment(department: Department) = departmentRepository.save(department)

    fun deleteDepartmentById(id: UUID) = departmentRepository.deleteById(id)

}