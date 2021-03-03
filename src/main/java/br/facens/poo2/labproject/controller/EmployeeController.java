package br.facens.poo2.labproject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.facens.poo2.labproject.dto.EmployeeDTO;
import br.facens.poo2.labproject.dto.EmployeeInsertDTO;
import br.facens.poo2.labproject.dto.EmployeeUpdateDTO;
import br.facens.poo2.labproject.entity.Employee;
import br.facens.poo2.labproject.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<Employee> save(@RequestBody EmployeeInsertDTO insertDTO) {
    Employee employee = employeeService.save(insertDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
    return ResponseEntity.created(uri).body(employee);
  }

  @GetMapping("{id}")
  public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
    EmployeeDTO employeeDTO = employeeService.findById(id);
    return ResponseEntity.ok(employeeDTO);
  }

  @GetMapping
  public ResponseEntity<List<EmployeeDTO>> findAll() {
    List<EmployeeDTO> employeeDTOList = employeeService.findAll();
    return ResponseEntity.ok(employeeDTOList);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    employeeService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody EmployeeUpdateDTO updateDTO) {
    Employee employee = employeeService.update(id, updateDTO);
    return ResponseEntity.ok().body(employee);
  }

}
