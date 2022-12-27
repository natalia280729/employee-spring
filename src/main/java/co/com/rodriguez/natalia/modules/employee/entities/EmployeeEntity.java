package co.com.rodriguez.natalia.modules.employee.entities;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.rodriguez.natalia.crosscutting.domain.contants.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * EmployeeEntity
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee", schema = "public")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private int id;

  @Column(name = "emp_name")
  private String empName;

  @Column(name = "password")
  private String password;

  @Column(name = "gender")
  private String gender;

  @JsonFormat(pattern = Constants.SIMPLE_DATE_TIME_FORMAT)
  @Basic(optional = false)
  @Column(name = "birthday")
  private LocalDateTime birthday;

  @Column(name = "dep_id")
  private int depId;

  @Column(name = "imp_role_id")
  private int impRoleId;

  @Column(name = "rank")
  private int rank;

  @Column(name = "tel")
  private String tel;

  @Column(name = "email")
  private String email;

  @Column(name = "info")
  private String info;
}
