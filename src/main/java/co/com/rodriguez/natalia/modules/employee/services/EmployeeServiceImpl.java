package co.com.rodriguez.natalia.modules.employee.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.rodriguez.natalia.crosscutting.domain.EmployeeDto;
import co.com.rodriguez.natalia.crosscutting.domain.exceptions.CustomException;
import co.com.rodriguez.natalia.modules.employee.entities.EmployeeEntity;
import co.com.rodriguez.natalia.modules.employee.repositories.EmployeesRepository;
import co.com.rodriguez.natalia.utils.translate.EmployeesDaoToDtoTranslate;
import co.com.rodriguez.natalia.utils.translate.EmployeesDtoToDaoTranslate;

/**
 * Logica para la conexion a la tabla Employee contiene los metodos save, update y get
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

  @Autowired private EmployeesRepository employeesRepository;

  @Autowired private EmployeesDaoToDtoTranslate employeesDaoToDtoTranslate;

  @Autowired private EmployeesDtoToDaoTranslate employeesDtoToDaoTranslate;

  @Override
  public EmployeeDto save(EmployeeDto employeeDto) throws CustomException {
    return employeesDaoToDtoTranslate.translate(
        employeesRepository.save(employeesDtoToDaoTranslate.translate(employeeDto)));
  }

  @Override
  public EmployeeDto get(Integer id) throws CustomException {

    Optional<EmployeeEntity> employeeEntity = employeesRepository.findById(id);
    if (employeeEntity.isPresent()) {
      return employeesDaoToDtoTranslate.translate(employeeEntity.get());
    }
    return null;
  }

  @Override
  public List<EmployeeDto> getAll() throws CustomException {
    List<EmployeeDto> employeeDtos = new ArrayList<>();

    List<EmployeeEntity> employeeEntities = (List<EmployeeEntity>) employeesRepository.findAll();
    if (!employeeEntities.isEmpty()) {
      for (EmployeeEntity transactionsDB : employeeEntities) {
        employeeDtos.add(employeesDaoToDtoTranslate.translate(transactionsDB));
      }
    }
    return employeeDtos;
  }

  @Override
  public EmployeeDto put(Integer id, EmployeeDto employeeDto) throws CustomException {

    Optional<EmployeeEntity> old = employeesRepository.findById(id);
    if (!old.isPresent()) {
      throw new CustomException("Error");
    }
    EmployeeDto employeesDomainOld = employeesDaoToDtoTranslate.translate(old.get());
    employeesDomainOld.setBirthday(employeeDto.getBirthday());
    employeesDomainOld.setEmpName(employeeDto.getEmpName());
    employeesDomainOld.setEmail(employeeDto.getEmail());
    employeesDomainOld.setInfo(employeeDto.getInfo());
    employeesDomainOld.setTel(employeeDto.getTel());
    employeesDomainOld.setPassword(employeeDto.getPassword());
    employeesDomainOld.setDepId(employeeDto.getDepId());
    employeesDomainOld.setGender(employeeDto.getGender());
    employeesDomainOld.setImpRoleId(employeeDto.getImpRoleId());
    employeesDomainOld.setRank(employeeDto.getRank());

    return employeesDaoToDtoTranslate.translate(
        employeesRepository.save(employeesDtoToDaoTranslate.translate(employeesDomainOld)));
  }
}
