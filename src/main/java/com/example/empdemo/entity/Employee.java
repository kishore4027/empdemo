package com.example.empdemo.entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author kisho
 * Employee Entity Class
 */
@Entity
public class Employee implements Serializable{
  
private static final long serialVersionUID = -5625672209401983319L;
  private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_SEQ") Long id;
  @Column(length = 10)
  private Long no;
  @Column(length = 100)
  private String name;
  @JsonFormat(pattern = "dd/MM/yyyy")  
  private LocalDate dateOfJoin;
  private double salary;
  @ManyToOne
  @JoinColumn(name ="department_id",nullable = false)
  private Department department;
  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateOfJoin, department, id, name, no, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dateOfJoin, other.dateOfJoin) && Objects.equals(department, other.department)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(no, other.no)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", no=" + no + ", name=" + name + ", dateOfJoin=" + dateOfJoin + ", salary="
				+ salary + ", department=" + department + "]";
	}
	
}