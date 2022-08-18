package com.example.empdemo.exception.advise;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.empdemo.exception.employee.EmployeeInvalidSearchCriteriaException;
import com.example.empdemo.exception.employee.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeAdvise {
	
	  @ExceptionHandler(EmployeeNotFoundException.class)
	  ResponseEntity<Map<String, String>> employeeNotFoundHandler(EmployeeNotFoundException ex) {
		  Map<String, String> errorResponse = new HashMap<>();

		    errorResponse.put("message", ex.getLocalizedMessage());
		    errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	  }
	  
	  @ExceptionHandler(EmployeeInvalidSearchCriteriaException.class)
	  ResponseEntity<Map<String, String>> invalidSerchInputHandler(EmployeeInvalidSearchCriteriaException ex) {
		  Map<String, String> errorResponse = new HashMap<>();

		    errorResponse.put("message", ex.getMessage());
		    errorResponse.put("status", HttpStatus.UNPROCESSABLE_ENTITY.toString());
		    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	  }
	  @ExceptionHandler(Exception.class)
	  ResponseEntity<Map<String, String>> employeeNotFoundHandler(Exception ex) {
		  Map<String, String> errorResponse = new HashMap<>();
		    errorResponse.put("message", ex.getLocalizedMessage());
		    errorResponse.put("status", HttpStatus.UNPROCESSABLE_ENTITY.toString());
		    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  
}
