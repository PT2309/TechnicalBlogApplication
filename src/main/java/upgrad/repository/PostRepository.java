package upgrad.repository;

import org.springframework.stereotype.Repository;
import upgrad.model.Post;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public List<Post> getAllPosts(){

        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
        List<Post> resultList = query.getResultList();

        return resultList;
    }

    // JPQL for fetching one post from posts table
    //       return  em.find(Post.class, 4);
    public Post latestPost(){

        return null;
    }

    public Post createPost(Post newPost){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }

        return newPost;
    }

    public Post getPost(Integer postId){
        EntityManager em = emf.createEntityManager();
        Post post = em.find(Post.class, postId);
        return post;
    }

    public void updatedPost(Post updatedPost){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.merge(updatedPost);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
    }

    public void deletePost(Integer postId){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            Post post = em.find(Post.class, postId);
            em.remove(post);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }

    }
}
