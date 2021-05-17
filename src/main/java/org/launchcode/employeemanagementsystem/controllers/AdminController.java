package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.data.ProjectRepository;
import org.launchcode.employeemanagementsystem.data.UserRepository;
import org.launchcode.employeemanagementsystem.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String admin(Model model)
    {
        model.addAttribute("employees",userRepository.findAll());
        return "admin/landingPage";
    }
    @GetMapping("project")
    public String index(Model model) {
        model.addAttribute("projects",projectRepository.findAll());
        return "admin/projects";
    }

    @GetMapping("create")
    public String renderCreateProject(Model model) {
        model.addAttribute("title","Create Project");
        model.addAttribute("employeeProject",new Project());
        return "admin/create";
    }

    @PostMapping("create")
    public String createProject(@ModelAttribute @Valid Project newEmployeeProject, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Project");
            model.addAttribute("errorMsg","Bad data!");
            return "admin/create";
        }
        projectRepository.save(newEmployeeProject);
        return "redirect:/admin/project";
    }

    @GetMapping("employee/{username}")
    public String addEmployeeProjectForm(Model model,@PathVariable String username) {
        model.addAttribute("employee",userRepository.findByUsername(username));
        model.addAttribute("projects",projectRepository.findAll());
        return "admin/assignProject";
    }
}
