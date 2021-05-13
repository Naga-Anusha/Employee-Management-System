package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.data.UserRepository;
import org.launchcode.employeemanagementsystem.models.UserDetails;
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
    UserRepository userRepository;


    @GetMapping
    public String index(Model model) {
        //model.addAttribute("details",userRepository.findByUsername(loginFormDTO.getUsername()));
        return "employee/landingPage";
    }

    @GetMapping("edit")
    public String displayEditDetails(Model model){


        return "employee/edit";
    }

    @PostMapping("edit")
    public String ProcessEditDetails(@ModelAttribute @Valid UserDetails userDetails) {

        return "redirect:";
    }
}
