package br.facens.poo2.labproject.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.facens.poo2.labproject.dto.EmployeeInsertDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "TB_EMPLOYEE")
public class Employee implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
