package upgrad.service;

import org.springframework.beans.factory.annotation.Autowired;
import upgrad.model.Post;
import org.springframework.stereotype.Service;
import upgrad.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Service Class which is a component in our Spring Application
// This is part of our IoC container.

// In Java PostService.class = an object/Beans which Spring uses.
@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public PostService(){
        System.out.println("Inside Post Service");
    }

    public List<Post> getAllPosts() throws ClassNotFoundException, SQLException {

        return repository.getAllPosts();
    }

    public ArrayList<Post> getOnePost() throws ClassNotFoundException, SQLException {

        ArrayList<Post> onePost = new ArrayList<>(); // Empty collection of Post data.

        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblogapplication", "postgres", "postgres@123");

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("select * from posts where id = 4");

        while(rs.next()){
            Post post = new Post();
            post.setTitle(rs.getString("title"));
            post.setBody(rs.getString("body"));

            onePost.add(post);
        }

        connection.close();

        return onePost;
    }

    public void createPost(Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println(newPost);
    }

    public Post getPost(Integer postId){

        return repository.getPost(postId);
    }

    public void updatedPost(Post updatedPost){

        updatedPost.setDate(new Date());
        repository.updatedPost(updatedPost);
    }

    public void deletePost(Integer postId){

        repository.deletePost(postId);
    }
}
