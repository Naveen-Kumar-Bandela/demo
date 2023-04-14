package com.spring.resilience4j.repository;

import com.spring.resilience4j.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
