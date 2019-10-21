package controller;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.PostService;

import java.util.ArrayList;


@Controller
public class HomepageController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model){

        ArrayList<Post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
