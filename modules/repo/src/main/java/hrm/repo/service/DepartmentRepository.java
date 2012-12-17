package hrm.repo.service;

import hrm.repo.domain.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentRepository {

    public void create(Department department) throws SQLException;

    public Department findDepartmentByName(String name) throws SQLException;

    public void delete(Department department) throws SQLException;

    public List<Department> findAllDepartments() throws SQLException;

    public int findMaxId() throws SQLException;

}
