package hrm.repo.service;

import hrm.repo.domain.DepartmentManager;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/17/12
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DepartmentManagerRepository {

    public void create(DepartmentManager departmentManager) throws SQLException;
}
