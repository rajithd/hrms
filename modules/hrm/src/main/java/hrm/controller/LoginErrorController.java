package hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Responsible for displaying custom login error controller
 */

@Controller
public class LoginErrorController {

    @RequestMapping(value = "/login-error" , method = RequestMethod.GET)
    public String redirect(){
        return "login-error";

    }
}
