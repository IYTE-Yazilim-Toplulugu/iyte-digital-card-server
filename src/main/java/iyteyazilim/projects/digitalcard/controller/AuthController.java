package iyteyazilim.projects.digitalcard.controller;

import iyteyazilim.projects.digitalcard.dto.CommunityDto;
import iyteyazilim.projects.digitalcard.entity.Community;
import iyteyazilim.projects.digitalcard.entity.User;
import iyteyazilim.projects.digitalcard.service.impl.CommentService;
import iyteyazilim.projects.digitalcard.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @PostMapping("/loginUser")
    public void loginUser(@RequestBody User user) {

    }

    @PostMapping("/loginCommunity")
    public void loginCommunity(@RequestBody CommunityDto community) {

    }


    @PostMapping("/signUpCommunity")
    public void signUpCommunity(@RequestBody Community community) {

    }



}
