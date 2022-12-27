package co.com.rodriguez.natalia.modules.employee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.rodriguez.natalia.crosscutting.domain.EmployeeDto;
import co.com.rodriguez.natalia.crosscutting.domain.contants.EmployeesConstant;
import co.com.rodriguez.natalia.crosscutting.domain.exceptions.CustomException;
import co.com.rodriguez.natalia.modules.employee.usecases.EmployeeUseCase;

/**
 * Controlador de peticiones para la creacion, actualizacion y obtencion de los registros de la
 * tabla Employee
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@RestController
@RequestMapping(value = EmployeesConstant.PATH)
public class EmployeeController {

  @Autowired private EmployeeUseCase employeeUseCase;

  @PostMapping
  public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto)
      throws CustomException {
    return new ResponseEntity<>(employeeUseCase.create(employeeDto), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<EmployeeDto>> getAll() throws CustomException {
    return new ResponseEntity<>(employeeUseCase.getAll(), HttpStatus.OK);
  }

  @GetMapping(EmployeesConstant.ID_PATH)
  public ResponseEntity<EmployeeDto> get(@PathVariable(EmployeesConstant.ID) int id)
      throws CustomException {
    return new ResponseEntity<>(employeeUseCase.get(id), HttpStatus.OK);
  }

  @PutMapping(EmployeesConstant.ID_PATH)
  public ResponseEntity<EmployeeDto> putRegistre(
      @PathVariable(EmployeesConstant.ID) Integer id, @RequestBody EmployeeDto employeeDto)
      throws CustomException {
    return new ResponseEntity<>(employeeUseCase.put(id, employeeDto), HttpStatus.CREATED);
  }
}
