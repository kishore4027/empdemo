package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.empdemo.jpa.repo.DepartmentRepository;
import com.example.empdemo.jpa.repo.EmployeeRepository;

@SpringBootTest
@DataJpaTest
@EnableWebMvc
@EnableTransactionManagement
class DemoApplicationTests {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	void contextLoads() {
		
	}

}
