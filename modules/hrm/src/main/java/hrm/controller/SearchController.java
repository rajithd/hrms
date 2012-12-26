package hrm.controller;

import hrm.repo.domain.Employee;
import hrm.repo.service.DepartmentRepository;
import hrm.repo.service.EmployeeRepository;
import hrm.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

/**
 * Responsible for search users based on last name, department name and title
 */

@Controller
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    private static int NUMBER_OF_RECORDS_PER_PAGE = 50;

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(String lastName, String departmentName, String title, Model model, String page) throws SQLException {
        if (title == null || lastName == null || departmentName == null) {
            return "search";
        } else if (!RegexUtil.isValidateAlphaChars(lastName) || !RegexUtil.isValidateAlphaChars(departmentName) || !RegexUtil.isValidateAlphaChars(title)) {
            model.addAttribute("regex", true);
            return "search";
        } else {
            int pageNo = 1;
            if (page != null) {
                pageNo = Integer.parseInt(page);
            }
            List<Employee> employees = employeeRepository.searchEmployeeByNames(lastName,title,departmentName, (pageNo - 1) * NUMBER_OF_RECORDS_PER_PAGE, NUMBER_OF_RECORDS_PER_PAGE);
            int noOfRecords = employeeRepository.noOfRecords();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / NUMBER_OF_RECORDS_PER_PAGE);
            model.addAttribute("employees", employees);
            model.addAttribute("noOfPages", noOfPages);
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("lastName", lastName);
            model.addAttribute("departmentName", departmentName);
            model.addAttribute("title", title);
        }
        return "search";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(String searchCriteria, String firstName, String lastName, String departmentName, Model model, String page) throws SQLException {
//        if (searchCriteria.equals("Employee")) {
//            int pageNo = 1;
//            if (page != null){
//                pageNo = Integer.parseInt(page);
//            }
//            List<Employee> employees = employeeRepository.searchEmployeeByNames(firstName,lastName,(pageNo-1)*NUMBER_OF_RECORDS_PER_PAGE,NUMBER_OF_RECORDS_PER_PAGE);
//            int noOfRecords = employeeRepository.noOfRecords();
//            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / NUMBER_OF_RECORDS_PER_PAGE);
//            model.addAttribute("employees",employees);
//            model.addAttribute("noOfPages",noOfPages);
//            model.addAttribute("currentPage",pageNo);
//        } else if (searchCriteria.equals("Department")) {
//            Department department = departmentRepository.findDepartmentByNameReg(departmentName);
//            model.addAttribute("department", department);
//        }
        return "search";
    }


}
