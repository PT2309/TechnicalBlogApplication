package upgrad.controller;

import upgrad.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import upgrad.service.PostService;

import java.sql.SQLException;
import java.util.ArrayList;


@Controller
public class HomepageController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model) throws SQLException, ClassNotFoundException {

        ArrayList<Post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
