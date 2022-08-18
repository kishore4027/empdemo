package com.example.empdemo.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeForm {
	  	  
	  @NotNull(message = "EmployeeNo cannot be Empty")
	  @Size(min = 1,max = 10, message = "EmployeeNo allowed with Min 1 and Max 10 digits")
	  @Pattern(regexp="^\\d+$",message = "Only numbers allowed")
	  private String no;
	  @NotNull(message = "Name cannot be Empty")
	  @Size(min = 1,max = 100,message = "Name allowed with Min 1 and Max 100 charecters")
	  
	  @Pattern(regexp="[\\w\\s]+",message = "Only numbers allowed")	  
	  private String name;
	  @NotNull(message = "DateOfJoin cannot be Empty")
	  @Size(min = 1,max = 10,message = "DateOfJoin allowed with Min 1 and Max 10 digits")
	  @Pattern(regexp = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$",message="Invalid Date gieven, Date Format shoud be :dd/MM/yyyy")
	  private String dateOfJoin;
	  @NotNull(message = "Department cannot be Empty")
	  @Size(min = 2,max=2, message = "Invalid Department Input given")
	  private String depCode;
	  @NotNull(message = "EmployeeNo cannot be Empty")
	  @Size(min = 1,max = 10,message="message = \"EmployeeNo allowed with Min 1 and Max 10 digits\")")
	  @Pattern(regexp="^\\d+$",message = "Only numbers allowed")
	  private String salary;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public String getDepCode() {
		return depCode;
	}
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeForm [no=" + no + ", name=" + name + ", dateOfJoin=" + dateOfJoin + ", depCode=" + depCode
				+ ", salary=" + salary + "]";
	}
}
