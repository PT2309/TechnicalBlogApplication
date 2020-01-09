package upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import upgrad.model.Post;
import upgrad.service.PostService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("posts")
    public String getPost(Model model) throws SQLException, ClassNotFoundException {

        List<Post> post = postService.getAllPosts();

        model.addAttribute("posts", post);

        return "posts";
    }

    @RequestMapping("posts/create")
    public String newPost(){
        return "posts/create";
    }

    @RequestMapping(value = "posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost){

        postService.createPost(newPost);

        return "redirect:/posts";
    }

    @RequestMapping(value ="/editPost", method= RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer postId, Model model){

        Post post = postService.getPost(postId);

        model.addAttribute("post", post);

        return "posts/edit";
    }

    @RequestMapping(value="/editPost", method=RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name="postId") Integer postId, Post updatedPost){

//        System.out.println("**************" + postId + "*************");
        updatedPost.setId(postId);

//        System.out.println("**************" + updatedPost + "*************");

        postService.updatedPost(updatedPost);

        return "redirect:/posts";
    }

    @RequestMapping(value="/deletePost", method = RequestMethod.DELETE)
    public String deletePost(@RequestParam(name = "postId") Integer postId){

        postService.deletePost(postId);
        return "redirect:/posts";
    }
}
