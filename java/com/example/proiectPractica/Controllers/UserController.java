package com.example.proiectPractica.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/noAccess")
    public String noAccess()
    {
        return "noAccess";
    }

    @PostMapping("/login_error")
    public String login_error()
    {
        return "login_error";
    }
}
