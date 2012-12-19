package hrm.repo.service.impl;


import hrm.repo.domain.Title;
import hrm.repo.service.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TitleRepositoryImpl implements TitleRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Title title) throws SQLException {
        final String sql = "insert into `titles` values(?,?,?,?)";
        Object[] params = new Object[]{title.getEmployeeNo(),title.getTitleName(),title.getFromDate(),title.getToDate()};
        jdbcTemplate.update(sql,params);
    }

    @Override
    public Title findTitleByEmpNo(long empNo) throws SQLException {
        final String sql = "select * from titles where emp_no=?";
        Object[] param = new Object[]{empNo};
        return jdbcTemplate.queryForObject(sql,param,new RowMapper<Title>() {
            @Override
            public Title mapRow(ResultSet resultSet, int i) throws SQLException {
                Title title = new Title();
                title.setTitleName(resultSet.getString("title"));
                title.setFromDate(resultSet.getString("from_date"));
                title.setToDate(resultSet.getString("to_date"));
                return title;
            }
        });
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
