package hrm.repo;


import hrm.repo.domain.Employee;
import hrm.repo.util.EmployeeState;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {

    public void create(Employee employee) throws SQLException;

    public void update(Employee employee, long id) throws SQLException;

    public Employee findEmployeeById(long id) throws SQLException;

    public void changeEmployeeState(EmployeeState employeeState) throws SQLException;

    public List<Employee> findAllEmployee() throws SQLException;

}
