package hrm.controller;

import hrm.repo.service.*;
import hrm.repo.domain.*;
import hrm.util.AuthorityLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Responsible for create employees
 */

@Controller
@RequestMapping(value = "/create-employee")
public class CreateEmployeeController {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private DepartmentEmployeeRepository departmentEmployeeRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String redirect(Model model){
        int employeeId = employeeRepository.findMaxEmployeeId()+1;
        model.addAttribute("empId",employeeId);
        return "create-employee";
    }

    @ModelAttribute("depList")
    public List<Department> populateDepartments() throws SQLException {
        return departmentRepository.findAllDepartments();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Employee employee, Title title, Salary salary, EmployeeDepartment employeeDepartment){
        int employeeId = employeeRepository.findMaxEmployeeId() + 1;
        employee.setEmployeeNo(employeeId);
        title.setEmployeeNo(employeeId);
        salary.setEmployeeNo(employeeId);
        employeeDepartment.setEmployeeNo(employeeId);
        employeeDepartment.setDepartmentNo(Long.parseLong(employee.getDepartmentSelect()));
        try {
            employeeRepository.create(employee);
            titleRepository.create(title);
            salaryRepository.create(salary);
            departmentEmployeeRepository.create(employeeDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
            return "system-error";
        }
        return "success";
    }

    private void addUsersAndAuthority(){

    }


}
