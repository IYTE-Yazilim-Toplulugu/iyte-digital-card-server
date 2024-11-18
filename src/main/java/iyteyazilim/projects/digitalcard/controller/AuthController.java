package iyteyazilim.projects.digitalcard.controller;

import iyteyazilim.projects.digitalcard.dto.CommunityLoginDto;
import iyteyazilim.projects.digitalcard.dto.UserLoginDto;
import iyteyazilim.projects.digitalcard.entity.Community;
import iyteyazilim.projects.digitalcard.entity.User;
import iyteyazilim.projects.digitalcard.dto.AdminLoginDto;
import iyteyazilim.projects.digitalcard.service.impl.CommunityService;
import iyteyazilim.projects.digitalcard.service.impl.AdminService;
import iyteyazilim.projects.digitalcard.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommunityService communityService;

    @Autowired
    private AdminService adminService;

    // User Login Endpoint
    @PostMapping("/userLogin")
    public String loginUser(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
        // İYTE'ye request gönder ve yanıtı al
        boolean isUserValid = userService.validateWithIyte(userLoginDto);

        if (isUserValid) {
            // Session'da kullanıcı bilgisini tut
            session.setAttribute("user", userLoginDto);

            // Kullanıcının database'de var olup olmadığını kontrol et
            if (!userService.isUserExist(userLoginDto.getEmail())) {
                User newUser = new User(userLoginDto.getEmail());
                userService.addUser(newUser);
            }
            return "User logged in successfully.";
        }
        return "Invalid user credentials.";
    }


    // Community Login Endpoint
    @PostMapping("/communityLogin")
    public String loginCommunity(@RequestBody CommunityLoginDto communityLoginDto, HttpSession session) {
        // Community login işlemi
        boolean isAuthenticated = communityService.validateWithIyte(communityLoginDto);

        if (isAuthenticated) {
            if (!communityService.isCommunityExist(communityLoginDto.getEmail())) {
                Community newCommunity = new Community(communityLoginDto.getEmail());
                communityService.addCommunity(newCommunity);
            }
            session.setAttribute("community", communityLoginDto);
            return "Community logged in successfully.";
        }
        return "Invalid community credentials.";
    }

    // Admin Login Endpoint
    @PostMapping("/adminLogin")
    public String adminLogin(@RequestBody AdminLoginDto adminLoginDto, HttpSession session) {
        // Admin login işlemi
        boolean isAdminAuthenticated = adminService.authenticateAdmin(adminLoginDto.getEmail(), adminLoginDto.getPassword());

        if (isAdminAuthenticated) {
            session.setAttribute("admin", adminLoginDto);
            return "Admin logged in successfully.";
        }
        return "Invalid admin credentials.";
    }
}
