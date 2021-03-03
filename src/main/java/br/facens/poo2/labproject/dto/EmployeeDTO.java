package br.facens.poo2.labproject.dto;

import br.facens.poo2.labproject.entity.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

  private Long id;
  private String name;
  private String email;

  public EmployeeDTO(Employee employee) {
    this.id = employee.getId();
    this.name = employee.getName();
    this.email = employee.getEmail();
  }

}
