package hrm.repo.service.impl;

import hrm.repo.domain.User;
import hrm.repo.service.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public void create(User user) {
        final String sql = "insert into users values(?,?,?)";
        Object[] params = new Object[]{user.getEmployeeNo(),user.getUsername(),user.getPassword()};
        jdbcTemplate.update(sql,params);

    }

    @Override
    public void changePassword(String currentPassword, String newPassword) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
