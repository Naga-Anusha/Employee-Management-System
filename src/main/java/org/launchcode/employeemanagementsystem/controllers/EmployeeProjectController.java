package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.data.EmployeeProjectRepository;
import org.launchcode.employeemanagementsystem.data.UserRepository;
import org.launchcode.employeemanagementsystem.models.EmployeeProject;
import org.launchcode.employeemanagementsystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin")
public class EmployeeProjectController {

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String admin(Model model)
    {
        model.addAttribute("employees",userRepository.findAll());
//        for(User user : userRepository.findAll()){
//            //if(user.isMatchingRole("employee")) {
//                model.addAttribute("employees",user.getUsername());
//            //}
//        }
        return "admin/landingPage";
    }
    @GetMapping("project")
    public String index(Model model) {
        model.addAttribute("projects",employeeProjectRepository.findAll());
        return "admin/projects";
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
        return "redirect:/admin/project";
    }
}
