package jmp.amarchuk.service;

import jmp.amarchuk.model.User;

import java.util.List;

public interface UserService {

    /**
     * User Id. UNIQUE.
     * @return User Id.
     */

    /**
     * User email. UNIQUE.
     * @return User email.
     */
    User getUserById(long userId);

    User getUserByEmail(String email);

    List<User> getUsersByName(String name, int pageSize, int pageNum);

    User createUser(User user);

    User updateUser(User user);

    boolean deleteUser(long userId);

    List<User> getAllUsers();
}
