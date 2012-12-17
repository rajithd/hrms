package hrm.repo.service.impl;

import hrm.repo.service.AuthorityRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/17/12
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class AuthorityRepositoryImpl implements AuthorityRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> findDistinctAuthority() throws SQLException{
        final String sql = "select distinct level from authority";
        List<String> strings = jdbcTemplate.query(sql,new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("level");
            }
        });
        return strings;
    }

    @Override
    public void create(long empNo, String role, String level) throws SQLException {
        final String sql = "insert into authority values(?,?,?)";
        Object[] p  = new Object[]{empNo,role,level};
        jdbcTemplate.update(sql,p);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
