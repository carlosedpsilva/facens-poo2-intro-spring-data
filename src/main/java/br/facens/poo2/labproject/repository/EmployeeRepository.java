package br.facens.poo2.labproject.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.facens.poo2.labproject.entity.Employee;

@Component
public class EmployeeRepository {

  // Using List to store
  private ArrayList<Employee> employees = new ArrayList<>();

  private Long nextId = 1L;

  public List<Employee> findAll() {
    return employees;
  }

  public Optional<Employee> findById(Long id) {
    for (Employee employee : employees)
      if (employee.getId() == id)
        return Optional.of(employee);
    return Optional.empty();
  }

  public Employee save(Employee employee) {
    employee.setId(nextId++);
    employees.add(employee);
    System.out.println(employee);
    return employee;
  }

  public void delete(Employee employee) {
    employees.remove(employee);
  }

  public Employee update(Employee employee) {
    Employee repoEmployee = findById(employee.getId()).get();
    // update entity
    if (repoEmployee != null) {
      repoEmployee.setPassword(employee.getPassword());
      repoEmployee.setAddress(employee.getAddress());
    }
    System.out.println(repoEmployee);
    return repoEmployee;
  }
}
