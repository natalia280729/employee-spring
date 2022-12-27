package co.com.rodriguez.natalia.modules.employee.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.rodriguez.natalia.modules.employee.entities.EmployeeEntity;

/**
 * @author Natalia Andrea Rodriguez Morales
 * @version 1.0
 * @since 2022-06-28
 */
@Repository("employeesDAO")
public interface EmployeesRepository extends CrudRepository<EmployeeEntity, Integer> {
  /** */
}
