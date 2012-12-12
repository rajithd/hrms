package hrm.repo;

import hrm.repo.domain.Department;

import java.sql.SQLException;

public interface DepartmentRepository {

    public void create(Department department) throws SQLException;

    public Department findDepartmentByName(String name) throws SQLException;

    public void delete(Department department) throws SQLException;

}
