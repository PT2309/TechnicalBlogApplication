package upgrad.repository;

import org.springframework.stereotype.Repository;
import upgrad.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
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
}
