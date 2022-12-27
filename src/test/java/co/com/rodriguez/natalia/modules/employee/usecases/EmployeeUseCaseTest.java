package co.com.rodriguez.natalia.modules.employee.usecases;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.rodriguez.natalia.crosscutting.domain.EmployeeDto;
import co.com.rodriguez.natalia.crosscutting.domain.exceptions.CustomException;
import co.com.rodriguez.natalia.modules.employee.services.IEmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeUseCaseTest {

  @InjectMocks private EmployeeUseCase employeeUseCase;
  @Mock private IEmployeeService iEmployeeService;
  private EmployeeDto employeeDto;
  private EmployeeDto employeeDtoComplete;

  @Before
  public void setUp() throws Exception {
    employeeDto =
        EmployeeDto.builder()
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
  }

  @Test
  public void testCreate() throws CustomException {
    when(iEmployeeService.save(any())).thenReturn(employeeDtoComplete);
    assertNotNull(employeeUseCase.create(employeeDto));
  }

  @Test
  public void testGet() throws CustomException {
    List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
    employeeDtos.add(employeeDtoComplete);
    when(iEmployeeService.getAll()).thenReturn(employeeDtos);
    assertNotNull(employeeUseCase.getAll());
  }

  @Test
  public void testGetAll() throws CustomException {
    when(iEmployeeService.get(any())).thenReturn(employeeDtoComplete);
    assertNotNull(employeeUseCase.get(1));
  }

  @Test
  public void testPut() throws CustomException {
    when(iEmployeeService.put(any(), any())).thenReturn(employeeDtoComplete);
    assertNotNull(employeeUseCase.put(1, employeeDtoComplete));
  }
}
