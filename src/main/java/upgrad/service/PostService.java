package upgrad.service;

import upgrad.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


// Service Class which is a component in our Spring Application
// This is part of our IoC container.

// In Java PostService.class = an object/Beans which Spring uses.
@Service
public class PostService {

    public ArrayList<Post> getAllPosts(){

        ArrayList<Post> posts = new ArrayList<>(); // Empty collection of Post data.

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

        return posts;
    }

    public ArrayList<Post> getOnePost(){

        ArrayList<Post> onePost = new ArrayList<>(); // Empty collection of Post data.

        Post post1 = new Post();
        post1.setTitle("User Post");
        post1.setBody("This is my User blog post");
        post1.setDate(new Date());

        onePost.add(post1);

        return onePost;
    }

    public void createPost(Post post){

    }
}
