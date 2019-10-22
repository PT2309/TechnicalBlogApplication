package upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import upgrad.model.Post;
import upgrad.service.PostService;

import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("posts")
    public String getPost(Model model){

        ArrayList<Post> post = postService.getOnePost();

        model.addAttribute("posts", post);

        return "posts";
    }
}
