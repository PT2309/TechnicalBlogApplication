package upgrad.repository;

import org.springframework.stereotype.Repository;
import upgrad.model.User;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public void registerUser(User newUser){

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();
            em.persist(newUser);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    public User validateUser(String username, String password){

        try{
            EntityManager em = emf.createEntityManager();
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            return query.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }

    }
}
