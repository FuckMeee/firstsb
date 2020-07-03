package com.hope.firstsb.service;

import com.hope.firstsb.domain.po.User;

import java.util.List;

/**
 * @author zwh
 */
public interface UserService {
    User getUserById(Integer id);

    int addUser(User user);

    List<User> getUserList();
}
