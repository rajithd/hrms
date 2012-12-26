package hrm.repo.service.impl;

import hrm.repo.domain.Department;
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
                employee1.setHireDate(resultSet.getString("hire_date"));
                return employee1;
            }
        });
    }

    @Override
    public void changeEmployeeState(long empNo, String state) throws SQLException {
        final String sql = "update employees set status=? where id=?";
        Object[] param = new Object[]{state, empNo};
        jdbcTemplate.update(sql, param);
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
    public List<Employee> searchEmployeeByNames(String lastName, String title, String depName, int offset, int noOfRecords) throws SQLException {
        final String sql = " select employees.last_name,titles.title,departments.name from employees,titles,departments where " +
                "employees.last_name like '" + lastName + "%' OR titles.title like '" + title + "%' OR departments.name like '" + depName + "%' " +
                "limit " + offset + "," + noOfRecords;

        List<Employee> employees = jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setLastName(resultSet.getString("last_name"));
                Title title = new Title();
                title.setTitleName(resultSet.getString("title"));
                employee.setTitle(title);
                Department department = new Department();
                department.setName(resultSet.getString("name"));
                employee.setDepartment(department);
                return employee;
            }
        });
        return employees;
    }

    @Override
    public int noOfRecords() {
        final String sql = "select count(*) from employees";
        return jdbcTemplate.queryForInt(sql);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
