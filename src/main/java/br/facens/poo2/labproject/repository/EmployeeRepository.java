package br.facens.poo2.labproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.facens.poo2.labproject.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
