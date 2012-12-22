package hrm.controller;


import hrm.repo.service.EmployeeRepository;
import hrm.repo.util.EmployeeState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/account-activation")
public class AccountActivationController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(){
        return "account-activation";
    }

    @ModelAttribute("stateList")
    public List<String> populateState(){
        List<String> list = new ArrayList<String>();
        list.add(EmployeeState.ACTIVE.name());
        list.add(EmployeeState.INACTIVE.name());
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(String empNo, String stateSelect, Model model){
        try {
            employeeRepository.findEmployeeById(Long.parseLong(empNo));
            employeeRepository.changeEmployeeState(Long.parseLong(empNo),stateSelect);
        } catch (Exception e) {
            model.addAttribute("emptyEmployee",true);
            return "account-activation";
        }
        return "success";
    }
}
