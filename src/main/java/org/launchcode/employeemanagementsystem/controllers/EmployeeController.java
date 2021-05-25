package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.data.UserDetailsRepository;
import org.launchcode.employeemanagementsystem.data.UserRepository;
import org.launchcode.employeemanagementsystem.models.User;
import org.launchcode.employeemanagementsystem.models.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;


    @GetMapping
    public String index(Model model, HttpSession session) {
        String sessionId = session.getId();
        int id = Integer.parseInt(sessionId);
        model.addAttribute("details",userRepository.findById(id));
        return "employee/landingPage";
    }

    @GetMapping("edit/{id}")
    public String displayEditDetails(Model model, @PathVariable String id){
        model.addAttribute(new User());
        model.addAttribute("employee",userRepository.findByUsername(id));
        return "employee/edit";
    }

    @PostMapping("edit")
    public String ProcessEditDetails(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String contactEmail,@RequestParam String address,@RequestParam String phoneNumber,@ModelAttribute @Valid UserDetails userDetails) {
        Optional<UserDetails> myUser = userDetailsRepository.findById(id);
        if (myUser.isPresent()) {
            UserDetails editedUser = (UserDetails) myUser.get();
            editedUser.setFirstName(firstName);
            editedUser.setLastName(lastName);
            editedUser.setContactEmail(contactEmail);
            editedUser.setAddress(address);
            editedUser.setPhoneNumber(phoneNumber);
            userDetailsRepository.save(editedUser);
        }

        return "redirect:";
    }
}
