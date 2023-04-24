package jmp.amarchuk.service;

import jmp.amarchuk.DAO.UserDaoDBImpl;
import jmp.amarchuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDBService implements UserService {

    @Autowired
    UserDaoDBImpl userDaoDBImpl;


    public UserDBService(UserDaoDBImpl userDaoDBImpl) {

        this.userDaoDBImpl = userDaoDBImpl;
    }


    public User getUserById(long userId) {
        return userDaoDBImpl.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userDaoDBImpl.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDaoDBImpl.getUsersByName(name,pageSize,pageNum);
    }

    public User createUser(User user) {
        return userDaoDBImpl.createUser(user);
    }

    public User updateUser(User user) throws NullPointerException {
        User userUpdated=userDaoDBImpl.updateUser(user);
        if(userUpdated==null){
            throw new NullPointerException("Error updating user "+user);
        }
        return userUpdated;
    }

    public boolean deleteUser(long userId) {
        return userDaoDBImpl.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoDBImpl.getAllUsers();
    }

}
