package hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: rajith
 * Date: 12/20/12
 * Time: 6:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/success")
public class SuccessController {

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(){
        return "success";
    }
}
