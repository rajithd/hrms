package hrm.repo.service;

import hrm.repo.domain.Title;

import java.sql.SQLException;

public interface TitleRepository {

    public void create(Title title) throws SQLException;

    public Title findTitleByEmpNo(long empNo) throws SQLException;
}
