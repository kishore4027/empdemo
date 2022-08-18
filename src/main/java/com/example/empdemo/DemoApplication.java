package com.example.empdemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.empdemo.entity.Department;
import com.example.empdemo.jpa.repo.DepartmentRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Component
	class DemoCommandLineRunner implements CommandLineRunner{

		@Autowired
		DepartmentRepository departmentRepository;
		
		@Override
		public void run(String... args) throws Exception {

			Department dep1 = new Department();
			dep1.setCode("AD");
			dep1.setDescription("Administration");
			Department dep2 = new Department();
			dep2.setCode("IT");
			dep2.setDescription("Information technology");
			Department dep3 = new Department();
			dep3.setCode("HD");
			dep3.setDescription("Help Desk");
			Department dep4 = new Department();
			dep4.setCode("HR");
			dep4.setDescription("Human Resource");
			Department dep5 = new Department();
			dep5.setCode("OP");
			dep5.setDescription("Operation");
			List<Department> depList=Stream.of(dep1,dep2,dep3,dep4,dep5).collect(Collectors.toList());
			departmentRepository.saveAll(depList);
			
		}
	}

}
