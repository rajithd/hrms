package hrm.repo.service.impl;

import hrm.repo.domain.Salary;
import hrm.repo.service.SalaryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/17/12
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class SalaryRepositoryImpl implements SalaryRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Salary salary) {
        final String sql = "insert into `salaries` values(?,?,?,?)";
        Object[] params = new Object[]{salary.getEmployeeNo(), Double.parseDouble(salary.getAmount()),salary.getFromDate(),salary.getToDate()};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public List<Salary> findSalaryByEmpNo(long empNo) throws SQLException {
        final String sql = "select * from salaries where emp_no=?";
        Object[] param = new Object[]{empNo};
        return jdbcTemplate.query(sql,param,new RowMapper<Salary>() {
            @Override
            public Salary mapRow(ResultSet resultSet, int i) throws SQLException {
                Salary salary = new Salary();
                salary.setAmount(String.valueOf(resultSet.getDouble("salary")));
                salary.setFromDate(resultSet.getString("from_date"));
                salary.setToDate(resultSet.getString("to_date"));
                return salary;
            }
        });
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
