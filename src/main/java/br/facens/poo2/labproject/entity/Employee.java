package br.facens.poo2.labproject.entity;

import br.facens.poo2.labproject.dto.EmployeeInsertDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {

  private Long id;
  private String name;
  private String email;
  private String password;
  private String address;

  public Employee(EmployeeInsertDTO insertDTO) {
    this.name = insertDTO.getName();
    this.email = insertDTO.getEmail();
    this.password = insertDTO.getPassword();
    this.address = insertDTO.getAddress();
  }

}
