package hrm.repo.service.impl;

import hrm.repo.domain.Title;
import hrm.repo.service.EmployeeRepository;
import hrm.repo.domain.Employee;
import hrm.repo.util.EmployeeState;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeRepositoryImpl implements EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Employee employee) throws SQLException {
        final String sql = "insert into `employees`(id,birth_date,first_name,last_name,gender,hire_date,status) values(?,?,?,?,?,?,?) ";
        Object[] params = new Object[]{employee.getEmployeeNo(), employee.getDateOfBirth(), employee.getFirstName(), employee.getLastName(),
                employee.getGender(), employee.getHireDate(), EmployeeState.ACTIVE.name()};
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
                employee1.setDateOfBirth(resultSet.getString("birth_date"));
                employee1.setGender(resultSet.getString("gender"));
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

    @Override
    public int findMaxEmployeeId() {
        final String sql = "select max(id) from employees";
        return jdbcTemplate.queryForInt(sql);
    }

    @Override
    public List<Employee> searchEmployeeByNames(String firstName, String lastName) throws SQLException {
        final String sql = " select employees.first_name,employees.last_name,titles.title from employees,titles where first_name like '"+firstName+"%' or last_name like '"+lastName+"%' and employees.id=titles.emp_no limit 10";
        Object[] params = new Object[]{"@"+firstName,"@"+lastName};
        List<Employee> employees = jdbcTemplate.query(sql,new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                Title title = new Title();
                title.setTitleName(resultSet.getString("title"));
                employee.setTitle(title);
                return employee;
            }
        });
        return employees;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
