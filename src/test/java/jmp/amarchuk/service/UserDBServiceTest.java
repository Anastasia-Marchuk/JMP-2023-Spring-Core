package jmp.amarchuk.service;

import jmp.amarchuk.model.User;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserDBServiceTest {

    private static Logger logger = LoggerFactory.getLogger(UserDBServiceTest.class);

    private static User testUser;
    private static User testUser2;
    private static User testUser3;
    private static List<User> listUsers=new ArrayList<>();

    UserDBService userService = mock(UserDBService.class);

    @Before
    public void init() {
        logger.info("Adding test user to list ");
        testUser = new User(1, "Stacy", "stacy@gmail.com");
        testUser2 = new User(2, "Paul", "paul@gmail.com");
        testUser3 = new User(3, "Paul", "paul2@gmail.com");
        listUsers.add(testUser);
        listUsers.add(testUser2);
        listUsers.add(testUser3);
    }

    @Test
    void getUserById() {

        logger.info("Run getUserById test...");
        when(userService.getUserById(1)).thenReturn(testUser);
        User resultUser=userService.getUserById(1);
        Assertions.assertEquals(testUser,resultUser);

    }

    @Test
    void getUserByEmail() {

        logger.info("Run getUserByEmail test...");
        when(userService.getUserByEmail("stacy@gmail.com")).thenReturn(testUser);
        User resultUser=userService.getUserByEmail("stacy@gmail.com");
        Assertions.assertEquals(testUser,resultUser);
    }

    @Test
    void getUsersByName() {

        logger.info("Run getUsersByName test...");
        List <User> listPaul=new ArrayList<>();
        listPaul.add(testUser2);
        listPaul.add(testUser3);

        when(userService.getUsersByName("Paul", 1, 2)).thenReturn(listPaul);
        List <User> result=userService.getUsersByName("Paul", 1, 2);
        Assertions.assertEquals(listPaul, result);
    }

    @Test
    void createUser() {

        logger.info("Run createUser test...");
        User newUser=new User(4,"New User", "newuser@gmail.com");
        when(userService.createUser(newUser)).thenReturn(newUser);
        User userFromService=userService.createUser(newUser);
        Assertions.assertEquals(userFromService,newUser);



//        ????????????????????????
        User newUser2=new User(4,"New User", "newuser@gmail.com");
        when(userService.createUser(newUser2)).thenReturn(newUser2);

    }

    @Test
    void updateUser() {

        logger.info("Run updateUser test...");
        User updatedUser=new User(1,"Updated User","updatedEmail@gmail.com");
        when(userService.updateUser(updatedUser)).thenReturn(updatedUser);
        User result=userService.updateUser(updatedUser);
        Assertions.assertEquals(updatedUser,result);
    }

    @Test
    void deleteUser() {

        logger.info("Run deleteUser test...");
        when(userService.deleteUser(1)).thenReturn(true);
        boolean delition=userService.deleteUser(1);
        Assertions.assertEquals(delition,true);

    }
}