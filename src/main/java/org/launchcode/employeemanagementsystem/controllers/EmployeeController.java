package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.data.UserRepository;
import org.launchcode.employeemanagementsystem.models.User;
import org.launchcode.employeemanagementsystem.models.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    UserRepository userRepository;


    @GetMapping
    public String index(Model model) {

        return "employee/landingPage";
    }

    @GetMapping("edit/{username}")
    public String displayEditDetails(Model model, @PathVariable String username){
       // model.addAttribute(new User());
        model.addAttribute("employee",userRepository.findByUsername(username));
        return "employee/edit";
    }

    @PostMapping("edit")
    public String ProcessEditDetails(@ModelAttribute @Valid User user,Model model) {
        Optional<User> myUser = userRepository.findById(user.getId());
        if (myUser.isPresent()) {
            User editedUser = (User) myUser.get();
            userRepository.save(editedUser);
        }
        return "redirect:";
    }
}
