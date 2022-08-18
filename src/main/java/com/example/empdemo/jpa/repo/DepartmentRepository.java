package com.example.empdemo.jpa.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.empdemo.entity.Department;
@Repository("departmentRepository")

public interface DepartmentRepository extends CrudRepository<Department, Long>{
  //@EntityGraph(type = EntityGraphType.FETCH,attributePaths = {"employees"})
  Optional<Department> findByCode(String code);
  
}
