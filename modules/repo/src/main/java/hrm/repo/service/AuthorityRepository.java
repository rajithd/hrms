package hrm.repo.service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/17/12
 * Time: 11:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AuthorityRepository {

    public List<String> findDistinctAuthority() throws SQLException;

    public void create(long empNo,String role, String level) throws SQLException;
}
