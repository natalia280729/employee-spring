package co.com.rodriguez.natalia.modules.employee.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.rodriguez.natalia.crosscutting.domain.EmployeeDto;
import co.com.rodriguez.natalia.crosscutting.domain.exceptions.CustomException;
import co.com.rodriguez.natalia.modules.employee.entities.EmployeeEntity;
import co.com.rodriguez.natalia.modules.employee.repositories.EmployeesRepository;
import co.com.rodriguez.natalia.utils.translate.EmployeesDaoToDtoTranslate;
import co.com.rodriguez.natalia.utils.translate.EmployeesDtoToDaoTranslate;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

  @InjectMocks private EmployeeServiceImpl employeeServiceImpl;

  @Mock private EmployeesRepository employeesRepository;

  @Mock private EmployeesDaoToDtoTranslate employeesDaoToDtoTranslate;

  @Mock private EmployeesDtoToDaoTranslate employeesDtoToDaoTranslate;

  private EmployeeEntity employeeEntity;
  private EmployeeDto employeeDtoComplete;

  @Before
  public void setUp() throws Exception {
    employeeDtoComplete =
        EmployeeDto.builder()
            .id(1)
            .birthday(LocalDateTime.now())
            .depId(0)
            .email("ddd")
            .empName("dsdsad")
            .gender("M")
            .impRoleId(0)
            .password("xxxxx")
            .rank(0)
            .tel("55555")
            .build();

    employeeEntity =
        EmployeeEntity.builder()
            .id(1)
            .birthday(LocalDateTime.now())
            .depId(0)
            .email("ddd")
            .empName("dsdsad")
            .gender("M")
            .impRoleId(0)
            .password("xxxxx")
            .rank(0)
            .tel("55555")
            .build();
  }

  @Test
  public void testGet() throws CustomException {
    Optional<EmployeeEntity> opt = Optional.ofNullable(employeeEntity);
    when(employeesRepository.findById(any())).thenReturn(opt);
    when(employeesDtoToDaoTranslate.translate(any())).thenReturn(employeeEntity);
    when(employeesDaoToDtoTranslate.translate(any())).thenReturn(employeeDtoComplete);
    assertNotNull(employeeServiceImpl.get(1));
  }

  @Test
  public void testGetAll() throws CustomException {
    List<EmployeeEntity> employeeDtos = new ArrayList<EmployeeEntity>();
    employeeDtos.add(employeeEntity);
    when(employeesRepository.findAll()).thenReturn(employeeDtos);
    when(employeesDtoToDaoTranslate.translate(any())).thenReturn(employeeEntity);
    when(employeesDaoToDtoTranslate.translate(any())).thenReturn(employeeDtoComplete);
    assertNotNull(employeeServiceImpl.getAll());
  }

  @Test
  public void testPut() throws CustomException {
    Optional<EmployeeEntity> opt = Optional.ofNullable(employeeEntity);
    when(employeesRepository.findById(any())).thenReturn(opt);
    when(employeesDtoToDaoTranslate.translate(any())).thenReturn(employeeEntity);
    when(employeesDaoToDtoTranslate.translate(any())).thenReturn(employeeDtoComplete);
    assertNotNull(employeeServiceImpl.put(1, employeeDtoComplete));
  }
}
