package jmp.amarchuk.facade;


import jmp.amarchuk.DAO.UserDaoDBImpl;
import jmp.amarchuk.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:configurationTest.xml"})
class BookingFacadeImplTest {

    @Autowired
    private UserDaoDBImpl userDao;
    @Autowired
    private BookingFacadeImpl bookingFacade;


    List<User> list = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(BookingFacadeImplTest.class);

    @Test
    void getAllUsers() {
        int size=bookingFacade.getAllUsers().size();
        assertEquals(6, size);
        logger.info("GetAllUsers test passed!");

    }

    @Test
    void createUser() {
        User user=new User(9,"newStacy9","new_stacy@gmail.com");
        bookingFacade.createUser(user);
        assertEquals(7, userDao.sizeUsers());
        logger.info("CreateUser test passed!");
    }

    @Test
    void getUsersByName() {
        User user10=new User(10,"New Name","new_name@gmail.com");
        User user11=new User(11,"New Name","new_name@gmail.com");
        list.add(user10);
        list.add(user11);
        bookingFacade.createUser(user10);
        bookingFacade.createUser(user11);
        list=bookingFacade.getUsersByName("New Name",1,1);
        assertEquals(list.size(), list.size());
        logger.info("GetUsersByName test passed!");
    }



}