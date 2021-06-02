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
import java.util.ArrayList;
import java.util.List;
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
        return "employee/assignments";
    }
    @PostMapping("assignments")
    public String processAssignments(@ModelAttribute Assignments assignments,HttpSession session,@RequestParam int noOfAssignments){
        User user = getUserFromSession(session);
            assignments.setUserId(user.getId());
            assignmentsRepository.save(assignments);
        return "redirect:";
    }
    @GetMapping("view")
    public String viewInformation(HttpSession session,Model model){
        User loggedUser = getUserFromSession(session);
        model.addAttribute("user",loggedUser);
        model.addAttribute("projects",employeeProjectRepository.findAll());
        Iterable<Assignments> assignments = new ArrayList<>();
        List<Assignments> userAssignments = new ArrayList<>();
        assignments = assignmentsRepository.findAll();
        for (Assignments assignment:assignments) {
            if(assignment.getUserId() == loggedUser.getId()){
                userAssignments.add(assignment);
            }
        }
        Assignments finalAssignment = userAssignments.get(0);
        for(int i=1; i<userAssignments.size();i++){
            if(userAssignments.get(i).getId() > finalAssignment.getId()){
                finalAssignment = userAssignments.get(i);
            }
        }
        model.addAttribute("assignment",finalAssignment);
        return "employee/view";
    }
}
