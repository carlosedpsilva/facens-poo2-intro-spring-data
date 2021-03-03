package br.facens.poo2.labproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeInsertDTO {
  private String name;
  private String email;
  private String password;
  private String address;
}
