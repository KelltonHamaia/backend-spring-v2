package com.mkt.dev.backendspring.services;

import com.mkt.dev.backendspring.model.User;
import com.mkt.dev.backendspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRP;

    public String createNewUser( String name, String email, String password, @DateTimeFormat(pattern = "dd/MM/yyyy") Date birthday){
        Optional<User> alreadyExists = userRP.findByEmail(email);
        if(alreadyExists.isPresent()) {
            return "user already exists.";
        }
        User user = new User(name, email, password, birthday);
        userRP.save(user);
        return "User "+ user.getName() + " successfully created.";
    }
    public Iterable<User> getAllUsers(){
        return userRP.findAll();
    }
    public Boolean loginUser(String email, String password) {
        Optional<User> user = userRP.findByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    public Iterable<User> getUsersByBirthdayBetween(Date offset, Date limit) {
        return userRP.findAllByBirthdayBetween(offset, limit);
    }
    public Optional<User> getUserById(Long id){
        return userRP.findById(id);
    }
    public String updateUser(Long id, String new_name, String new_email, String new_password, Date new_birthday) {
        Optional<User> user = userRP.findById(id);

        if(user.isPresent()) {
            User updatedUser = user.get();
            if(new_name != null) {
                updatedUser.setName(new_name);
            }

            if(new_email != null && userRP.findByEmail(new_email).isEmpty()) {
                updatedUser.setEmail(new_email);
            }

            if(new_password != null) {
                updatedUser.setPassword(new_password);
            }

            if(new_birthday != null) {
                updatedUser.setBirthday(new_birthday);
            }
            userRP.save(updatedUser);
            return "Data successfully updated.";
        }
        return "User not found.";
    }

    public Iterable<User> getLastLoggedUsers() {
        Date yesterday = new Date(System.currentTimeMillis() - (1000 * 3600 * 24));
        return userRP.findByUpdatedAtAfter(yesterday);
    }

}
