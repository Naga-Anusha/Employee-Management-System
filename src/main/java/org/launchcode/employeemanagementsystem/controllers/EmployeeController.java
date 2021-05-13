package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.models.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("employee")
public class EmployeeController {


    @GetMapping
    public String index(Model model) {

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
