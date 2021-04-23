package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.models.EmployeeProject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class ProjectController {

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("create")
    public String renderCreateProject() {
        return "admin/create";
    }

    @PostMapping("create")
    public String createProject(@ModelAttribute EmployeeProject employeeProject){
        return "redirect:";
    }
}
