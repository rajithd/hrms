package hrm.repo;


import hrm.repo.domain.Employee;
import hrm.repo.util.EmployeeState;

import java.util.List;

public interface EmployeeRepository {

    public void create(Employee employee);

    public void update(Employee employee, long id);

    public Employee findEmployeeById(long id);

    public void changeEmployeeState(EmployeeState employeeState);

    public List<Employee> findAllEmployee();

}
