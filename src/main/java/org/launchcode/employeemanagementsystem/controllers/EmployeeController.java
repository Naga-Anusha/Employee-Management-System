package org.launchcode.employeemanagementsystem.controllers;

import org.launchcode.employeemanagementsystem.data.AssignmentsRepository;
import org.launchcode.employeemanagementsystem.data.EmployeeProjectRepository;
import org.launchcode.employeemanagementsystem.data.UserDetailsRepository;
import org.launchcode.employeemanagementsystem.data.UserRepository;
import org.launchcode.employeemanagementsystem.models.Assignments;
import org.launchcode.employeemanagementsystem.models.User;
import org.launchcode.employeemanagementsystem.models.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    AssignmentsRepository assignmentsRepository;

    @Autowired
    EmployeeProjectRepository employeeProjectRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }
    @GetMapping
    public String index(Model model, HttpSession session) {
        User loggedUser =  getUserFromSession(session);
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
    @GetMapping("assignments")
    public String displayAssignments(Model model,HttpSession session){
        User loggedUser =  getUserFromSession(session);
        Optional<User> myUser = userRepository.findById(loggedUser.getId());
        if (myUser.isPresent()) {
            User user = (User) myUser.get();
            model.addAttribute("assignments",user.getAssignments());
            return "employee/editAssignments";
        }
        return "employee/assignments";
    }
    @PostMapping("assignments")
    public String processAssignments(@ModelAttribute Assignments assignments,HttpSession session,@RequestParam int noOfAssignments,@RequestParam int id){
        Optional<Assignments> myUser = assignmentsRepository.findById(id);
        if (myUser.isPresent()) {
            Assignments editedUser = (Assignments) myUser.get();
            User user = getUserFromSession(session);
            editedUser.setUser(user);
            editedUser.setNoOfAssignments(noOfAssignments);
            assignmentsRepository.save(editedUser);
        }
        else {
            User user = getUserFromSession(session);
            assignments.setUser(user);
            assignmentsRepository.save(assignments);
        }
        return "redirect:";
    }
    @GetMapping("view")
    public String viewInformation(HttpSession session,Model model){
        User loggedUser = getUserFromSession(session);
        model.addAttribute("user",loggedUser);
        model.addAttribute("projects",employeeProjectRepository.findAll());
        return "employee/view";
    }
}
