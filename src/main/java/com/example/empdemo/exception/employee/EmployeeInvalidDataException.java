package com.example.empdemo.exception.employee;

import java.io.Serializable;

import org.springframework.validation.Errors;

public class EmployeeInvalidDataException extends RuntimeException  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5687127537399031862L;
	public EmployeeInvalidDataException() {
		
	}
	public EmployeeInvalidDataException(Long id) {
				
	}
	public EmployeeInvalidDataException(Errors errors) {
		//super("Invalid Data input given, empNo:"+errors.+" name:"+name);
	  
	}
}
