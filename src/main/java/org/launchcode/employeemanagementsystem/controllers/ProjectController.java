package org.launchcode.employeemanagementsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin")
public class ProjectController {

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("create")
    public String renderCreateEvent() {
        return "admin/create";
    }
}
