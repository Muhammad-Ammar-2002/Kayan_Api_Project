package com.projects.kayan_API.Controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(HttpServletRequest request)
    {
return
    String.format(
            "Hello from Java project.\nThis %s is your Session ID.", request.getSession().getId());

        }
    }
