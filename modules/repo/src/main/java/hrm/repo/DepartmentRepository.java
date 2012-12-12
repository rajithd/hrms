package hrm.repo;

import hrm.repo.domain.Department;

public interface DepartmentRepository {

    public void create(Department department);

    public Department findDepartmentByName(String name);

    public void delete(Department department);

}
