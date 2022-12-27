package co.com.rodriguez.natalia.crosscutting.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EmployeeDto
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {

  private static final long serialVersionUID = 1311663033937537410L;

  private int id;

  private String empName;

  private String password;

  private String gender;

  private LocalDateTime birthday;

  private int depId;

  private int impRoleId;

  private int rank;

  private String tel;

  private String email;

  private String info;
}
