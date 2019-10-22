package upgrad.service;

import org.springframework.stereotype.Service;
import upgrad.model.User;

@Service
public class UserService {

    public boolean validUser(User user){
        if(user.getUsername().equals("Upgrad")){
            return true;
        } else
        {
            return false;
        }
    }
}
