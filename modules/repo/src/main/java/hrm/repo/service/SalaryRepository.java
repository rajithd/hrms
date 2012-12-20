package hrm.repo.service;

import hrm.repo.domain.Salary;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/17/12
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface SalaryRepository {

    public void create(Salary salary);

    public List<Salary> findSalaryByEmpNo(long empNo) throws SQLException;
}
