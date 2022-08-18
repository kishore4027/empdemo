package com.example.empdemo.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empdemo.entity.Department;
import com.example.empdemo.jpa.repo.DepartmentRepository;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentRepository departmentRepository;
	@GetMapping("/departments")
	List<Department> all() {	    
	    List<Department> result = new ArrayList<>();
	    Iterable<Department> all=departmentRepository.findAll();
	    if(all!=null) {
	    all.forEach(result::add);
	    }
	   return result;
	}
}
