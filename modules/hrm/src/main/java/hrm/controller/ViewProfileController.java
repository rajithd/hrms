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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Responsible for view profile
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
        Collection<GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Set<String> roles = new HashSet<String>();
        for (GrantedAuthority role : authorities) {
            roles.add(role.getAuthority());
        }
        if (roles.contains("ROLE_ADMIN_LOGIN") || roles.contains("ROLE_HR_LOGIN")) {
            return "view-profile";
        } else {
            long empNo = userRepository.findEmployeeNoByUsername(username);
            Employee employee = employeeRepository.findEmployeeById(empNo);
            Title title = titleRepository.findTitleByEmpNo(empNo);
            List<Salary> salaries = salaryRepository.findSalaryByEmpNo(empNo);
            model.addAttribute("empNo", empNo);
            model.addAttribute("employee", employee);
            model.addAttribute("title", title);
            model.addAttribute("salary", salaries.get(salaries.size() - 1));
            model.addAttribute("view", true);
            return "view-profile";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(String employeeNo, Model model) throws SQLException {
        if (employeeNo == null || employeeNo.equals("")) {
            model.addAttribute("empNoEmpty", true);
            return "view-profile";
        } else {
            model.addAttribute("empNoEmpty", false);
            long empNo = Long.parseLong(employeeNo);
            Employee employee = null;
            try {
                employee = employeeRepository.findEmployeeById(empNo);
            } catch (Exception e){
                model.addAttribute("emptyEmployee",true);
                return "view-profile";
            }
            if (employee == null){
                model.addAttribute("emptyEmployee",true);
                return "view-profile";
            }
            Title title = titleRepository.findTitleByEmpNo(empNo);
            List<Salary> salaries = salaryRepository.findSalaryByEmpNo(empNo);
            model.addAttribute("empNo", empNo);
            model.addAttribute("employee", employee);
            model.addAttribute("title", title);
            model.addAttribute("salary", salaries.get(salaries.size() - 1));
            model.addAttribute("view", true);
            return "view-profile";
        }
    }
}
