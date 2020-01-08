package upgrad.controller;

import upgrad.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import upgrad.service.PostService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    public HomeController(){
        System.out.println("Inside Home Controller");
    }

    @RequestMapping("/")
    public String getAllPosts(Model model) throws SQLException, ClassNotFoundException {

        List<Post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
