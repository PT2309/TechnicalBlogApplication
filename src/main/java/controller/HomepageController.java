package controller;

import model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomepageController {

    @RequestMapping("/")
    public String getAllPosts(Model model){

        List<Post> posts = new ArrayList<>(); // Empty collection of Post data.

        Post post1 = new Post();
        post1.setTitle("My First Blog");
        post1.setBody("I want a great Spring Boot Application");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("My Second Blog");
        post2.setBody("I want a great Spring Boot Application");
        post2.setDate(new Date());

        posts.add(post1);
        posts.add(post2);


        model.addAttribute("posts", posts);

        return "index";
    }
}
