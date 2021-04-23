package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.data.EmployeeProjectRepository;
import org.launchcode.employeemanagementsystem.models.EmployeeProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class EmployeeProjectController {

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("projects",employeeProjectRepository.findAll());
        return "admin/index";
    }

    @GetMapping("create")
    public String renderCreateProject(Model model) {
        model.addAttribute("title","Create Project");
        model.addAttribute("employeeProject",new EmployeeProject());
        return "admin/create";
    }

    @PostMapping("create")
    public String createProject(@ModelAttribute @Valid EmployeeProject newEmployeeProject, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Project");
            model.addAttribute("errorMsg","Bad data!");
            return "admin/create";
        }
        employeeProjectRepository.save(newEmployeeProject);
        return "redirect:";
    }
}
