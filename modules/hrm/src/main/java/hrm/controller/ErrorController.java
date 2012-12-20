package hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/system-error")
public class ErrorController {

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(){
        return "system-error";

    }
}
