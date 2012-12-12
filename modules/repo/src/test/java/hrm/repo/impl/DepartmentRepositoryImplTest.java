package hrm.repo.impl;

import hrm.repo.domain.Department;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:repo-factory-spring-test.xml"})
public class DepartmentRepositoryImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DepartmentRepositoryImpl departmentRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        deleteTestDepartment();
    }

    @Test
    public void testCreate() throws Exception {
        departmentRepository.create(createDepartment());
        int count = jdbcTemplate.queryForInt("select count(*) from departments where name='test'");
        Assert.assertEquals(1,count);

    }

    @Test
    public void testFindDepartmentByName() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    private Department createDepartment() {
        Department department = new Department();
        department.setName("test");
        return department;
    }

    private void deleteTestDepartment() {
        jdbcTemplate.update("delete from departments where name='test'");
    }


}
