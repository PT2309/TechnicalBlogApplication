package upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import upgrad.model.Post;
import upgrad.model.User;
import upgrad.model.UserProfile;
import upgrad.service.PostService;
import upgrad.service.UserService;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    // Default GET request
    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping(value = "users/login", method= RequestMethod.POST)
    public String loginUser(User user, HttpSession session){
        User existingUser = userService.validUser(user);
        if( existingUser != null) {
            session.setAttribute("loggeduser", existingUser);
            return "redirect:/posts";
        } else {
            return "users/login";
        }
    }

    @RequestMapping("users/registration")
    public String registration(Model model){
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);

        model.addAttribute("User", user);

        return "users/registration";
    }

    @RequestMapping(value="users/registration", method = RequestMethod.POST)
    public String register(User user){
        userService.registerUser(user);

        return "users/login";
    }

    @RequestMapping(value="users/logout", method = RequestMethod.POST)
    public String logout(Model model, HttpSession session) throws SQLException, ClassNotFoundException {
        session.invalidate();

        List<Post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }



}
