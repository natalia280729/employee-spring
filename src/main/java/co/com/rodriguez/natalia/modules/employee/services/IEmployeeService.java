package co.com.rodriguez.natalia.modules.employee.services;

import java.util.List;

import co.com.rodriguez.natalia.crosscutting.domain.EmployeeDto;
import co.com.rodriguez.natalia.crosscutting.domain.exceptions.CustomException;

/**
 * Interfaz para la clase EmployeeServiceImpl
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
public interface IEmployeeService {

  public EmployeeDto save(EmployeeDto employeeDto) throws CustomException;

  public EmployeeDto get(Integer id) throws CustomException;

  public EmployeeDto put(Integer id, EmployeeDto employeeDto) throws CustomException;

  public List<EmployeeDto> getAll() throws CustomException;
}
