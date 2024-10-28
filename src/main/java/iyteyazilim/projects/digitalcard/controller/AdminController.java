package iyteyazilim.projects.digitalcard.controller;


import iyteyazilim.projects.digitalcard.entity.User;
import iyteyazilim.projects.digitalcard.service.impl.AdminService;
import iyteyazilim.projects.digitalcard.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService; // UserService'i bağımlılık olarak ekleyin


    @GetMapping("/getUsers")
    public List<User> getAllUsers(@RequestParam("email") String email, @RequestParam("password") String password) {
        // Admin doğrulaması
        boolean isAuthenticated = adminService.authenticateAdmin(email, password);
        if (isAuthenticated) {
            return userService.getUsers(); // Kullanıcıların listesini döndür
        } else {
            throw new RuntimeException("Unauthorized: Access is denied.");
        }
    }
}
