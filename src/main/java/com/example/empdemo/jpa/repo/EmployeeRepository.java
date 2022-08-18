package com.example.empdemo.jpa.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empdemo.entity.Employee;
@Repository("employeeRepository")

public interface EmployeeRepository extends CrudRepository<Employee, Long>,JpaSpecificationExecutor<Employee>{
	@Transactional
	@Modifying
	@Query(value="update Employee e set e.no=:no,e.name=:name,e.salary=:salary,e.date_Of_Join=:dateOfJoin,e.department_id=:department_id where e.id=:id",nativeQuery = true)
	public int updateEmployee(@Param("no") Long no, @Param("name") String name,@Param("salary") double salary,@Param("department_id") Long deptId,@Param("id") Long id,@Param("dateOfJoin") LocalDate dateOfJoin	);
	@Query(value="select e from Employee e where lower(e.name) like %:name% or concat(e.no,'') like %:no%")
	public List<Employee> findByNoAndNameContainingIgnoreCase(@Param("name")String name,@Param("no")String no);
	@Query(value="select e from Employee e where lower(e.name) like %:name%")
	public List<Employee> findByNameContainingIgnoreCase(@Param("name")String name);
	@Query(value="select e from Employee e where concat(e.no,'') like %:no%")
	public List<Employee> findByEmployeeNo(@Param("no")String no);
	
	
	
}
