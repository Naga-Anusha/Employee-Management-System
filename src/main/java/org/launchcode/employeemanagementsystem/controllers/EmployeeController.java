package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.data.EmployeeRepository;
import org.launchcode.employeemanagementsystem.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("details",employeeRepository.findAll());
        return "employee/landingPage";
    }

    @GetMapping("create")
    public String renderCreate(Model model){
            model.addAttribute("title","Create Details");
            model.addAttribute("employee",new Employee());
            return "employee/create";

    }

    @PostMapping("create")
    public String createDetails(@ModelAttribute @Valid Employee newEmployee, Errors errors,Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Update Details");
            model.addAttribute("errorMsg","Bad data!");
            return "employee/create";
        }
        if(employeeRepository.findAll() == null){
            employeeRepository.save(newEmployee);
        }
        return "redirect:";
    }

    @GetMapping("edit")
    public String displayEditDetails(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("values",employeeRepository.findAll());
        return "employee/edit";
    }

    @PostMapping("edit")
    public String ProcessEditDetails(@ModelAttribute @Valid Employee newEmployee) {
        employeeRepository.save(newEmployee);
        return "redirect:";
    }
}
