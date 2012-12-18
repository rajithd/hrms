package hrm.repo.service.impl;

import hrm.repo.domain.User;
import hrm.repo.service.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/17/12
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(User user) throws SQLException {
        final String sql = "insert into users values(?,?,?)";
        Object[] params = new Object[]{user.getEmployeeNo(),user.getUsername(),user.getPassword()};
        jdbcTemplate.update(sql,params);

    }

    @Override
    public void changePassword(String newPassword, String username) throws SQLException {
        final String sql = "update users set password=? where username=?";
        Object[] param = new Object[]{newPassword,username};
        jdbcTemplate.update(sql,param);
    }

    @Override
    public boolean isCorrectCurrentPassword(String password, String username) throws SQLException {
        final String sql = "select password from users where username=?";
        Object[] param = new Object[]{username};
        String pass = jdbcTemplate.queryForObject(sql,param,String.class);
        return pass.equals(password);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
