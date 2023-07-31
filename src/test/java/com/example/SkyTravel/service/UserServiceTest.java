package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.InvalidIdException;
import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.model.User;
import com.example.SkyTravel.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository mockRepo;

    @Test
    public void getsUserByIdTest() {
        User testUser = new User();
        testUser.setUser_id(1);
        testUser.setDisplay_name("test");
        testUser.setEmail("test@test.com");
        testUser.setPassword("password");
        Optional<User> optUser = Optional.of(testUser);
        when(mockRepo.findById(1)).thenReturn(optUser);

        //act
        User u = userService.getUserById(1);

        //assert
        assertEquals("test", u.getDisplay_name());
        verify(mockRepo, times(1)).findById(1);
    }

    @Test
    public void getUserByIdThrowsExceptionIfNegativeTest() {
        int userId = -1;

        //act
        InvalidIdException thrown = Assertions.assertThrows(InvalidIdException.class, () -> {
            userService.getUserById(userId);
        });

        //assert
        assertEquals("User ID is invalid", thrown.getMessage());
    }

    @Test
    public void getUserByIdThrowsExceptionIfNotFoundTest() {

        //arrange
        int userId = 10;

        //act
        Optional<User> optUser = Optional.empty();
        when(mockRepo.findById(userId)).thenReturn(optUser);
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            userService.getUserById(userId);
        });

        //assert

        assertEquals("User Not Found", thrown.getMessage());
        verify(mockRepo, times(1)).findById(userId);
    }
}
