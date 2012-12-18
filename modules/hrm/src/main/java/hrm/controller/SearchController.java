package hrm.controller;

import hrm.repo.domain.Department;
import hrm.repo.domain.Employee;
import hrm.repo.service.DepartmentRepository;
import hrm.repo.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/18/12
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(){
        return "search";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(String searchCriteria, String firstName, String lastName, String departmentName, Model model) throws SQLException {
        if(searchCriteria.equals("Employee")){
            List<Employee> employees = employeeRepository.searchEmployeeByNames(firstName,lastName);
            model.addAttribute("employees",employees);
        } else if(searchCriteria.equals("Department")){
            Department department = departmentRepository.findDepartmentByNameReg(departmentName);
            model.addAttribute("department",department);
        }
        return "search";
    }



}
