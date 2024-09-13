package iyteyazilim.projects.digitalcard.controller;

import iyteyazilim.projects.digitalcard.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    private String getAllUsers() {
        return "users";
    }
}
