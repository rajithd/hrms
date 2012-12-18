package hrm.controller;

import hrm.repo.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;


@Controller
@RequestMapping(value = "/change-password")
public class ChangePasswordController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String redirect() {
        return "change-password";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(String currentPassword, String newPassword) throws SQLException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (userRepository.isCorrectCurrentPassword(currentPassword,username)){
            userRepository.changePassword(newPassword,username);
        }
        return "change-password";
    }
}
