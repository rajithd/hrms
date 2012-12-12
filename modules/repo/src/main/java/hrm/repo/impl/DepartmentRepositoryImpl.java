package hrm.repo.impl;


import hrm.repo.DepartmentRepository;
import hrm.repo.domain.Department;
import org.springframework.jdbc.core.JdbcTemplate;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Department department) {
        final String sql = "";
    }

    @Override
    public Department findDepartmentByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Department department) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
