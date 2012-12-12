package hrm.repo.impl;

import hrm.repo.EmployeeRepository;
import hrm.repo.domain.Employee;
import hrm.repo.util.EmployeeState;
import hrm.repo.util.Gender;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeRepositoryImpl implements EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Employee employee) throws SQLException {
        final String sql = "insert into `employees`(birth_date,first_name,last_name,gender,hire_date,status) values(?,?,?,?,?,?) ";
        Object[] params = new Object[]{employee.getDateOfBirth(), employee.getFirstName(), employee.getLastName(),
                employee.getGender(), employee.getHireDate(), employee.getStatus()};
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void update(Employee employee, long id) throws SQLException {
//        final String sql = "update `employees` set "
    }

    @Override
    public Employee findEmployeeById(long id) throws SQLException {
        final String sql = "select * from `employees` where id=?";
        Object[] param = new Object[]{id};
        return jdbcTemplate.queryForObject(sql, param, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee1 = new Employee();
                employee1.setFirstName(resultSet.getString("first_name"));
                employee1.setLastName(resultSet.getString("last_name"));
                employee1.setDateOfBirth(resultSet.getDate("birth_date"));
                employee1.setGender(Gender.valueOf(resultSet.getString("gender")));
                return employee1;
            }
        });
    }

    @Override
    public void changeEmployeeState(EmployeeState employeeState) throws SQLException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Employee> findAllEmployee() throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
