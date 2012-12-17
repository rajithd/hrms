package hrm.controller;

import hrm.repo.domain.User;
import hrm.repo.service.AuthorityRepository;
import hrm.repo.service.UserRepository;
import hrm.util.AuthorityLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rajith
 * Date: 12/17/12
 * Time: 11:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/create-account")
public class CreateUserAccountController {

    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private UserRepository userRepository;

    private static String[] employeeRoles = {"ROLE_USER_LOGIN", "ROLE_VIEW_PROFILE", "ROLE_SEARCH", "ROLE_CHANGE_PASSWORD"};
    private static String[] adminRoles = {"ROLE_ADMIN_LOGIN", "ROLE_CREATE_USER_ACCOUNT", "ROLE_CREATE_DEPARTMENT", "ROLE_UPDATE_PROFILE", "ROLE_CREATE_PROFILE", "ROLE_VIEW_PROFILE", "ROLE_SEARCH", "ROLE_CHANGE_PASSWORD"};
    private static String[] hrRoles = {"ROLE_HR_LOGIN", "ROLE_UPDATE_PROFILE", "ROLE_CREATE_PROFILE", "ROLE_VIEW_PROFILE", "ROLE_SEARCH", "ROLE_CHANGE_PASSWORD"};

    @RequestMapping(method = RequestMethod.GET)
    public String redirect() {
        return "create-user-account";
    }

    @ModelAttribute("levels")
    public List<String> populateLevels() throws SQLException {
        return authorityRepository.findDistinctAuthority();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(User user) throws SQLException {
        userRepository.create(user);
        createAuthorityBasedOnLevel(user.getLevel(),user.getEmployeeNo());
        return "main";
    }

    private void createAuthorityBasedOnLevel(String level, long empNo) throws SQLException {
        if (level.equals(AuthorityLevel.ADMIN_USER.name())) {
            for (String role : adminRoles) {
                authorityRepository.create(empNo, role, level);
            }
        } else if (level.equals(AuthorityLevel.HR_EXECUTIVE.name())) {
            for (String role : hrRoles) {
                authorityRepository.create(empNo, role, level);
            }
        } else if (level.equals(AuthorityLevel.NORMAL_USER.name())) {
            for (String role : employeeRoles) {
                authorityRepository.create(empNo, role, level);
            }
        }

    }

}
