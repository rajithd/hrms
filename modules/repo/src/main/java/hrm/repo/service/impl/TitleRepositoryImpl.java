package hrm.repo.service.impl;


import hrm.repo.domain.Title;
import hrm.repo.service.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class TitleRepositoryImpl implements TitleRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Title title) throws SQLException {
        final String sql = "insert into `titles` values(?,?,?,?)";
        Object[] params = new Object[]{title.getEmployeeNo(),title.getTitleName(),title.getFromDate(),title.getToDate()};
        jdbcTemplate.update(sql,params);
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
