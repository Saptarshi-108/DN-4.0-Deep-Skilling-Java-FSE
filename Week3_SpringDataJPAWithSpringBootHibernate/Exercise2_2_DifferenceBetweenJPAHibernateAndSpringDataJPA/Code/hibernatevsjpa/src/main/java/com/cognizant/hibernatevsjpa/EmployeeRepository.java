package com.cognizant.hibernatevsjpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No additional methods required for basic CRUD
}