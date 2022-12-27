package co.com.rodriguez.natalia.modules.employee.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.rodriguez.natalia.crosscutting.domain.EmployeeDto;
import co.com.rodriguez.natalia.crosscutting.domain.exceptions.CustomException;
import co.com.rodriguez.natalia.modules.employee.services.IEmployeeService;

/**
 * Servicio de flujo del crud EmployeeEntity y sus validaciones
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@Component
public class EmployeeUseCase {

  @Autowired private IEmployeeService iEmployeeService;

  public EmployeeDto create(EmployeeDto employeeDto) throws CustomException {

    return this.iEmployeeService.save(employeeDto);
  }

  public EmployeeDto get(Integer id) throws CustomException {

    return this.iEmployeeService.get(id);
  }

  public List<EmployeeDto> getAll() throws CustomException {

    return this.iEmployeeService.getAll();
  }

  public EmployeeDto put(Integer id, EmployeeDto employeeDto) throws CustomException {

    return iEmployeeService.put(id, employeeDto);
  }
}
