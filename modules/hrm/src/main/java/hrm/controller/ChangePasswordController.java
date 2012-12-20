package hrm.controller;

import hrm.repo.service.EmployeeRepository;
import hrm.repo.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping(value = "/change-password")
public class ChangePasswordController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String redirect() {
        return "change-password";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(String currentPassword, String newPassword, String employeeNo, Model model) throws SQLException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Collection<GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Set<String> roles = new HashSet<String>();
        for (GrantedAuthority role : authorities) {
            roles.add(role.getAuthority());
        }
        if (roles.contains("ROLE_ADMIN_LOGIN") || roles.contains("ROLE_HR_LOGIN")) {
            if (employeeNo == null || employeeNo.equals("")) {
                model.addAttribute("empNoEmpty",true);
                return "change-password";
            }
            String empUsername = userRepository.findUsernameByEmpNo(Long.parseLong(employeeNo));
            if (userRepository.isCorrectCurrentPassword(currentPassword, empUsername)) {
                changePassword(newPassword, empUsername);
            }
        } else {
            if (userRepository.isCorrectCurrentPassword(currentPassword, username)) {
                changePassword(newPassword, username);
            }
        }
        model.addAttribute("empNoEmpty",false);
        return "success";
    }

    private void changePassword(String newPassword, String username) throws SQLException {
        userRepository.changePassword(newPassword, username);
    }
}
