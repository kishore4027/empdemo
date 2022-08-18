package com.example.empdemo.transform;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.example.empdemo.beans.EmployeeForm;
import com.example.empdemo.entity.Department;
import com.example.empdemo.entity.Employee;

public class CommonTransform {
	
	public static Employee convertFormToEmtity(EmployeeForm form) {
		Employee emp=new Employee();
		emp.setNo(Long.parseLong(form.getNo().trim()));
		emp.setName(form.getName().trim());
		emp.setDateOfJoin(getDateOfPattern("dd/MM/yyyy",form.getDateOfJoin().trim()));
		Department dep=new Department();
		dep.setCode(form.getDepCode().trim().toUpperCase());
		emp.setDepartment(dep);
		emp.setSalary(Double.parseDouble(form.getSalary().trim()));
		return emp;
	}
	public static Employee convertFormToEmtity(EmployeeForm form,Employee emp) {	
		emp.setNo(Long.parseLong(form.getNo().trim()));
		emp.setName(form.getName().trim());
		emp.setDateOfJoin(getDateOfPattern("dd/MM/yyyy",form.getDateOfJoin().trim()));
		Department dep=Optional.ofNullable(emp.getDepartment()).orElseGet(Department::new);
		dep.setCode(form.getDepCode().trim().toUpperCase());
		emp.setDepartment(dep);
		emp.setSalary(Double.parseDouble(form.getSalary().trim()));
		return emp;
	}
	public static LocalDate getDateOfPattern(String pattern,String dateVal) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.parse(dateVal.trim(),formatter);
	}

}
