package hrm.controller;

import hrm.repo.domain.Employee;
import hrm.repo.domain.Salary;
import hrm.repo.domain.Title;
import hrm.repo.service.EmployeeRepository;
import hrm.repo.service.SalaryRepository;
import hrm.repo.service.TitleRepository;
import hrm.repo.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/19/12
 * Time: 8:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/view-profile")
public class ViewProfileController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private SalaryRepository salaryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(Model model) throws SQLException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        long empNo = userRepository.findEmployeeNoByUsername(username);
        Employee employee = employeeRepository.findEmployeeById(empNo);
        Title title = titleRepository.findTitleByEmpNo(empNo);
        List<Salary> salaries = salaryRepository.findSalaryByEmpNo(empNo);
        model.addAttribute("empNo",empNo);
        model.addAttribute("employee",employee);
        model.addAttribute("title",title);
        model.addAttribute("salary",salaries.get(salaries.size()-1));
        return "view-profile";
    }
}
