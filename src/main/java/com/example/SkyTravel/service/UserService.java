package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.EmailExistException;
import com.example.SkyTravel.exception.InvalidIdException;
import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.User;
import com.example.SkyTravel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUserById(int id) {
        if(id > 0){
            Optional<User> optionalUser = userRepo.findById(id);
            return optionalUser.orElseThrow(() -> new NotFoundException("User Not Found"));
        }else{
            throw new InvalidIdException("User ID is invalid");
        }
    }

    public User postUser(User newUser) {
        if (userRepo.findByEmail(newUser.getEmail()) != null) {
            throw new EmailExistException("Email address is already registered");
        }
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

        return userRepo.save(newUser);
    }

    public String userName(String email){
        User user = userRepo.findByEmail(email);
        return  user.getDisplay_name();

    }


    public boolean authenticate(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null) {

            // Checking if the hashed password matches the provided password
            return bCryptPasswordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}
