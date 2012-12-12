package hrm.repo.impl;


import hrm.repo.DepartmentRepository;
import hrm.repo.domain.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Department department) throws SQLException {
        final String sql = "insert into `departments`(name) values(?) ";
        Object[] params = new Object[]{department.getName()};
        jdbcTemplate.update(sql, params);
    }

    @Override
    public Department findDepartmentByName(String name) throws SQLException {
        final String sql = "select id,name from `departments` where name=?";
        Object[] param = new Object[]{name};
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                Department department1 = new Department();
                department1.setDepartmentId(resultSet.getLong("id"));
                department1.setName(resultSet.getString("name"));
                return department1;
            }
        });
    }

    @Override
    public void delete(Department department) throws SQLException {
        final String sql = "delete from `departments` where id=? ";
        Object[] param = new Object[]{department.getName()};
        jdbcTemplate.update(sql, param);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
