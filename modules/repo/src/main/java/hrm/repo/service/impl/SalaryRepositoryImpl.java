package hrm.repo.service.impl;

import hrm.repo.domain.Salary;
import hrm.repo.service.SalaryRepository;
import org.springframework.jdbc.core.JdbcTemplate;

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


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
