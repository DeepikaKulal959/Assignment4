package com.example.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Optional <Employee> findByName(String name);

}
