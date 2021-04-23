package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.models.EmployeeProject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class EmployeeProjectController {

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("create")
    public String renderCreateProject(Model model) {
        model.addAttribute("title","Create Project");
        model.addAttribute(new EmployeeProject());
        return "admin/create";
    }

    @PostMapping("create")
    public String createProject(@ModelAttribute EmployeeProject employeeProject, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Project");
            model.addAttribute("errorMsg","Bad data!");
            return "events/create";
        }
        return "redirect:";
    }
}
