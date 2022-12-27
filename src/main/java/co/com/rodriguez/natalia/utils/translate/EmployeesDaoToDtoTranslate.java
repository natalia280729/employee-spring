package co.com.rodriguez.natalia.utils.translate;

import org.springframework.stereotype.Component;

import co.com.rodriguez.natalia.crosscutting.domain.EmployeeDto;
import co.com.rodriguez.natalia.crosscutting.domain.exceptions.CustomException;
import co.com.rodriguez.natalia.crosscutting.patterns.Translator;
import co.com.rodriguez.natalia.modules.employee.entities.EmployeeEntity;

/**
 * EmployeesDaoToDtoTranslate
 *
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@Component
public class EmployeesDaoToDtoTranslate implements Translator<EmployeeEntity, EmployeeDto> {

  @Override
  public EmployeeDto translate(EmployeeEntity input) throws CustomException {

    return EmployeeDto.builder()
        .id(input.getId())
        .empName(input.getEmpName())
        .password(input.getPassword())
        .gender(input.getGender())
        .birthday(input.getBirthday())
        .depId(input.getDepId())
        .impRoleId(input.getImpRoleId())
        .rank(input.getRank())
        .tel(input.getTel())
        .email(input.getEmail())
        .info(input.getInfo())
        .build();
  }
}
