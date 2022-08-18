package com.example.empdemo.employee;

import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.empdemo.entity.Employee;
import com.example.empdemo.jpa.SearchCriteria;
import com.example.empdemo.jpa.SearchOperation;

public class EmployeeSpecification implements Specification<Employee>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -160744200793467944L;

	
	private final SearchCriteria searchCriteria;

    public EmployeeSpecification(final SearchCriteria
                                 searchCriteria){
        super();
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Employee> root,
                     CriteriaQuery<?> query, CriteriaBuilder cb) {
        String strToSearch = searchCriteria.getValue()
                                          .toString().toLowerCase();
        
        switch(Objects.requireNonNull(
                               SearchOperation.getSimpleOperation
                               (searchCriteria.getOperation()))){
            case CONTAINS: 
            	if(searchCriteria.getValue() instanceof Number) {
            	return cb.like(root
                            .get(searchCriteria.getFilterKey()), 
                            "%" + strToSearch + "%");
            	}else {
                return cb.like(cb.lower(root
                         .get(searchCriteria.getFilterKey())), 
                         "%" + strToSearch + "%");
            	}

            case DOES_NOT_CONTAIN:             
                return cb.notLike(cb.lower(root
                         .get(searchCriteria.getFilterKey())), 
                         "%" + strToSearch + "%");
            case EQUAL:             
                return cb.equal(root
                         .get(searchCriteria.getFilterKey()), 
                		searchCriteria.getValue());
            default : return null;
        }
       
     }
     

}
