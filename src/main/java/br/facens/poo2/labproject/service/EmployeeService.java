package br.facens.poo2.labproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.facens.poo2.labproject.dto.EmployeeDTO;
import br.facens.poo2.labproject.dto.EmployeeInsertDTO;
import br.facens.poo2.labproject.dto.EmployeeUpdateDTO;
import br.facens.poo2.labproject.entity.Employee;
import br.facens.poo2.labproject.repository.EmployeeRepository;

@Service
public class EmployeeService implements IService<Employee, EmployeeDTO, EmployeeInsertDTO, EmployeeUpdateDTO> {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<EmployeeDTO> toDTOList(List<Employee> list) {
    List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    for (Employee employee : list) {
      EmployeeDTO dto = new EmployeeDTO(employee);
      employeeDTOList.add(dto);
    }
    return employeeDTOList;
  }

  @Override
  public Employee existsById(Long id) {
    Optional<Employee> employeeOpt = employeeRepository.findById(id);
    return employeeOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
  }

  @Override
  public List<EmployeeDTO> findAll() {
    List<Employee> employeeList = employeeRepository.findAll();
    return toDTOList(employeeList);
  }

  @Override
  public EmployeeDTO findById(Long id) {
    return new EmployeeDTO(existsById(id));
  }

  @Override
  public Employee save(EmployeeInsertDTO insertDTO) {
    Employee employeeEntity = new Employee(insertDTO);
    employeeEntity = employeeRepository.save(employeeEntity);
    return employeeEntity;
  }

  @Override
  public void delete(Long id) {
    employeeRepository.delete(existsById(id));
  }

  @Override
  public Employee update(Long id, EmployeeUpdateDTO updateDTO) {
    Employee repoEmployee = existsById(id);
    // update object
    repoEmployee.setId(id);
    repoEmployee.setPassword(updateDTO.getPassword());
    repoEmployee.setAddress(updateDTO.getAddress());
    return employeeRepository.update(repoEmployee);
  }
}
