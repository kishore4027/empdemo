package com.example.empdemo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
//@NamedEntityGraph(name = "department_entity_graph",attributeNodes = @NamedAttributeNode("employees"))
public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7446177096904308869L;
	private @Id @GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "DEP_SEQ")
	  Long id;
	  @Column(length = 2,nullable = false,unique = true)
	  private String code;
	  private String description;	  
	  @OneToMany(fetch = FetchType.LAZY, mappedBy = "department",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = false)	  
	  private List<Employee> employees;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}*/
	@Override
	public int hashCode() {
		return Objects.hash(code, description,  id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(code, other.code) && Objects.equals(description, other.description)
				 && Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", code=" + code + ", description=" + description + "]";
	}
	  
}
