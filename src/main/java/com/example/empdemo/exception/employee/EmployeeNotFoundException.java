package com.example.empdemo.exception.employee;

import java.io.Serializable;

/**
 * 
 * @author kisho
 *
 */
public class EmployeeNotFoundException extends RuntimeException implements Serializable {
		  /**
	 * 
	 */
	private static final long serialVersionUID = 4656310648415410267L;

		public EmployeeNotFoundException(Long id) {
		    super("Could not find employee " + id);
		  }		
}
