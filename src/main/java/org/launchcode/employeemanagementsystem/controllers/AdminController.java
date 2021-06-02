package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.data.EmployeeProjectRepository;
import org.launchcode.employeemanagementsystem.data.ProjectRepository;
import org.launchcode.employeemanagementsystem.data.UserRepository;
import org.launchcode.employeemanagementsystem.models.EmployeeProject;
import org.launchcode.employeemanagementsystem.models.Project;
import org.launchcode.employeemanagementsystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

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

    @GetMapping("assignProject")
    public String addEmployeeProjectForm(Model model) {
        model.addAttribute("users",userRepository.findAll());
        model.addAttribute("projects",projectRepository.findAll());
        return "admin/assignProject";
    }

    @PostMapping("assignProject")
    public String processEmployeeProjectForm(@ModelAttribute @Valid EmployeeProject newEmployeeProject,
                                             Errors errors, Model model, @RequestParam int projectId,@RequestParam int id){
        Optional<Project> optProject = projectRepository.findById(projectId);
        if(optProject.isPresent()) {
            Project project = optProject.get();
            newEmployeeProject.setProject(project);
        }
        Optional<User> optUser = userRepository.findById(id);
        if(optUser.isPresent()){
            User user = optUser.get();
            newEmployeeProject.setUser(user);
        }
        employeeProjectRepository.save(newEmployeeProject);
        return "redirect:";
    }
    @GetMapping("view/{username}")
    public String ViewDetails(Model model,@PathVariable String username){
        model.addAttribute("employee",userRepository.findByUsername(username));
        model.addAttribute("employeeProject",employeeProjectRepository.findAll());
        return "admin/employeeProjects";
    }

    @GetMapping("remove")
    public String displayRemoveEmployee(Model model) {
        model.addAttribute("employeeProjects",employeeProjectRepository.findAll());
        return "admin/remove";
    }

    @PostMapping("remove")
    public String processRemoveEmployee(@RequestParam(required = false) int[] id){
        if(id != null){
            for(int employeeProject : id){
                employeeProjectRepository.deleteById(employeeProject);
            }


        }
        return "redirect:";
    }

}
