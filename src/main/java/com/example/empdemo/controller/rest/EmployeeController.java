package com.example.empdemo.controller.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.empdemo.beans.EmployeeForm;
import com.example.empdemo.entity.Department;
import com.example.empdemo.entity.Employee;
import com.example.empdemo.exception.employee.EmployeeInvalidDataException;
import com.example.empdemo.exception.employee.EmployeeNotFoundException;
import com.example.empdemo.jpa.repo.DepartmentRepository;
import com.example.empdemo.jpa.repo.EmployeeRepository;
import com.example.empdemo.transform.CommonTransform;

@RestController
@Validated
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> all() {	    
	    List<Employee> result = new ArrayList<>();
	    Iterable<Employee> all=employeeRepository.findAll();
	    if(all!=null) {
	    all.forEach(result::add);
	    }
	   return new ResponseEntity<List<Employee>>(result,HttpStatus.OK);
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> get(@PathVariable Long id) {	    
		return new ResponseEntity<Employee>(employeeRepository.findById(id)
	      .orElseThrow(() -> new EmployeeNotFoundException(id)),HttpStatus.OK);
	 }
	@PostMapping("/employees")
	public ResponseEntity<Employee> newEmployee(@Valid @RequestBody EmployeeForm newEmployee, BindingResult errors) {
		if(errors.hasErrors()) {
		  throw new EmployeeInvalidDataException(errors);
		}else {
		Employee emp=CommonTransform.convertFormToEmtity(newEmployee);
		Department dep=departmentRepository.findByCode(emp.getDepartment().getCode())
		.orElseGet(() -> {
	    	 return departmentRepository.save(emp.getDepartment());	    	
	      });
		emp.setDepartment(dep);
		return new ResponseEntity<Employee>(employeeRepository.save(emp),HttpStatus.OK);
	 }		
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> replaceEmployee(@Valid @RequestBody EmployeeForm newEmployee, @Min(1)@PathVariable Long id) {	
		  Optional<Department> dep=departmentRepository.findByCode(newEmployee.getDepCode().trim().toUpperCase());
		  boolean isExists= employeeRepository.existsById(id);
		  if(!dep.isPresent()) {
			  throw new EmployeeInvalidDataException(id);
		  }
		  if(isExists) {
	       int count=employeeRepository.updateEmployee(Long.parseLong(newEmployee.getNo()), newEmployee.getName().trim(), Double.valueOf(newEmployee.getSalary().trim()), dep.get().getId(),id, CommonTransform.getDateOfPattern("dd/MM/yyyy",newEmployee.getDateOfJoin().trim()));
		  System.out.println("updatecount"+count);
		  }else {
			  throw new EmployeeNotFoundException(id);
		  }
		  Optional<Employee> _emp= employeeRepository.findById(id);
	
		return new ResponseEntity<>(_emp.get(),HttpStatus.OK);
	  }
	  @DeleteMapping("/employees/{id}")
	  public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		      if(employeeRepository.existsById(id)) {	        
		      employeeRepository.deleteById(id);
              return new ResponseEntity<>(HttpStatus.OK); 
		      }else {
		    	  throw new EmployeeNotFoundException(id);
		      }
	  }
	  /**
	     * Delete all employees
	     *
	     * @return ResponseEntity
	     */
	  @DeleteMapping("/employees")
	  public ResponseEntity<?> deleteAllEmployees() {
	    	    employeeRepository.deleteAll();
	    	    Map<String,String> response=new HashMap<>();
	            return new ResponseEntity<>(response,HttpStatus.OK);   
	   }
	  @GetMapping("/employees/search")
	  List<Employee> search(@RequestParam(required = false) String empNo,@RequestParam(required = false)String name) {	    
		    /*validation
		     * 1 either name or empno should >0 
		     * 2. if both there then basis combination we need to get it
		     */
		    
		    /*EmployeeSpecificationBuilder builder = new EmployeeSpecificationBuilder();
		    List<Employee> all=null;
		    List<SearchCriteria> criteriaList =new ArrayList<>();
		    //add empno criteria
		    if(Objects.nonNull(empNo) && empNo.trim().matches("\\d+")) {
		    SearchCriteria empNoCri=new SearchCriteria("no", SearchOperation.CONTAINS.name(),Long.parseLong(empNo.trim()));
		    criteriaList.add(empNoCri);
		    }
		    if(Objects.nonNull(name)) {
			    SearchCriteria empNoCri=new SearchCriteria("name", SearchOperation.CONTAINS.name(),name.trim());
			    criteriaList.add(empNoCri);
			}
		    if(!criteriaList.isEmpty()){
		    	criteriaList.forEach(x-> {
		    		x.setDataOption(SearchOperation.ANY.name());
		    		builder.with(x);
            });
		    all = employeeRepository.findAll(builder.build());			    
		    }else {
		    	throw new EmployeeInvalidSearchCriteriaException(empNo,name);
		    }*/
		  	List<Employee> all=null;		    
		    boolean isEmpNoValid=Objects.nonNull(empNo) && empNo.trim().matches("\\d+");
		  	boolean isNameValid=Objects.nonNull(name) && !name.trim().isEmpty();			
			boolean isBothValid=(isNameValid && isEmpNoValid);	
			if(isBothValid) {
			all=employeeRepository.findByNoAndNameContainingIgnoreCase(name.trim(),empNo.trim());
			}else if(isNameValid) {
				all=employeeRepository.findByNameContainingIgnoreCase(name.trim());					
			}else if(isEmpNoValid) {
				all=employeeRepository.findByEmployeeNo(empNo.trim());					
			}			
		    return Optional.ofNullable(all).orElseGet(ArrayList::new);		   
	  }
	  
	
}
