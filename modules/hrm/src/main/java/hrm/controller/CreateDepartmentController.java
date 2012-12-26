package hrm.controller;

import hrm.repo.domain.Department;
import hrm.repo.domain.DepartmentManager;
import hrm.repo.service.DepartmentManagerRepository;
import hrm.repo.service.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

/**
 * Responsible for create departments
 */

@Controller
@RequestMapping(value = "/create-department")
public class CreateDepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentManagerRepository departmentManagerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String redirect() {
        return "create-department";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(DepartmentManager departmentManager, Department department) throws SQLException {
        departmentRepository.create(department);
        int departmentNo = departmentRepository.findMaxId();
        departmentManager.setDepartmentNo(departmentNo);
        departmentManagerRepository.create(departmentManager);
        return "create-department";
    }
}
