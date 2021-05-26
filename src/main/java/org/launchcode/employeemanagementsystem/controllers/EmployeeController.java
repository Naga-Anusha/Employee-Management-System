package org.launchcode.employeemanagementsystem.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.launchcode.employeemanagementsystem.data.UserDetailsRepository;
import org.launchcode.employeemanagementsystem.data.UserRepository;
import org.launchcode.employeemanagementsystem.models.User;
import org.launchcode.employeemanagementsystem.models.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    private static final String userSessionKey = "user";
    @GetMapping
    public String index(Model model, HttpSession session) {
        Integer userId = (Integer)session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        User loggedUser =  user.get();
        //model.addAttribute("details",userRepository.findByUsername(loginFormDTO.getUsername()));
        model.addAttribute("details",userRepository.findByUsername(loggedUser.getUsername()));
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
