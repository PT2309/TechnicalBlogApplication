package upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import upgrad.model.Post;
import upgrad.model.User;
import upgrad.service.PostService;
import upgrad.service.UserService;

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
    public String loginUser(User user){
        if(userService.validUser(user)) {
            return "redirect:/posts";
        } else {
            return "users/login";
        }
    }

    @RequestMapping("users/registration")
    public String register(){
        return "users/registration";
    }

    @RequestMapping(value="users/registration", method = RequestMethod.POST)
    public String signUp(){
        return "users/login";
    }

    @RequestMapping("users/logout")
    public String logout(Model model) throws SQLException, ClassNotFoundException {

        List<Post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }



}
