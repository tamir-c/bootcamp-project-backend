package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.InvalidIdException;
import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.model.User;
import com.example.SkyTravel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User getUserById(int userId) {
        if(userId > 0){
            Optional<User> optionalUser = userRepo.findById(userId);
            return optionalUser.orElseThrow(() -> new NotFoundException("User Not Found"));
        }else{
            throw new InvalidIdException("User ID is invalid");
        }
    }
}
