package com.example.empdemo.exception.employee;

import java.io.Serializable;

public class EmployeeInvalidSearchCriteriaException extends RuntimeException implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 4478679801368697433L;

	public EmployeeInvalidSearchCriteriaException(String empNo, String name) {
		    super("Invalid search input given, empNo:"+empNo+" name:"+name);
		  }	
}
