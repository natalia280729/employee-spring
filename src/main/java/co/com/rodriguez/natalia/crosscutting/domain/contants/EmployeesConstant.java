package co.com.rodriguez.natalia.crosscutting.domain.contants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeesConstant {

  public static final String PATH = "/employee";
  public static final String ID_PATH = "/{id}";
  public static final String ID = "id";
}
