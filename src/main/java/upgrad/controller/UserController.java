package upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import upgrad.model.User;
import upgrad.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

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



}
