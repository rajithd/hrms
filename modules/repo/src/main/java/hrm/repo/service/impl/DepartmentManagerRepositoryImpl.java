package hrm.repo.service.impl;

import hrm.repo.domain.DepartmentManager;
import hrm.repo.service.DepartmentManagerRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/17/12
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class DepartmentManagerRepositoryImpl implements DepartmentManagerRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(DepartmentManager departmentManager) throws SQLException {
        final String sql = "insert into `dept_manager` values(?,?,?,?)";
        Object[] params = new Object[]{departmentManager.getDepartmentNo(),departmentManager.getEmployeeNo(),departmentManager.getFromDate(),departmentManager.getToDate()};
        jdbcTemplate.update(sql,params);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
