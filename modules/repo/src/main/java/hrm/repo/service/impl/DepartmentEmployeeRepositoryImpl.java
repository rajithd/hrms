package hrm.repo.service.impl;

import hrm.repo.domain.EmployeeDepartment;
import hrm.repo.service.DepartmentEmployeeRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class DepartmentEmployeeRepositoryImpl implements DepartmentEmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(EmployeeDepartment employeeDepartment) {
        final String sql = "insert into dept_emp values(?,?,?,?)";
        Object[] params = new Object[]{employeeDepartment.getEmployeeNo(), employeeDepartment.getDepartmentNo(), employeeDepartment.getFromDate(), employeeDepartment.getToDate()};
        jdbcTemplate.update(sql, params);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }
}
