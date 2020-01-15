package upgrad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upgrad.model.User;
import upgrad.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User validUser(User user){
        User existingUser = repository.validateUser(user.getUsername(), user.getPassword());

        if( existingUser != null){
            return existingUser;
        } else
            return null;

//        if(user.getUsername().equals("Upgrad")){
//            return true;
//        } else
//        {
//            return false;
//        }
    }

    public void registerUser(User newUser){

        repository.registerUser(newUser);
    }
}
