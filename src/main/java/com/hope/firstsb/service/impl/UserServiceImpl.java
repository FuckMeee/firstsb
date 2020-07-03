package com.hope.firstsb.service.impl;

import com.hope.firstsb.dao.UserMapper;
import com.hope.firstsb.domain.po.User;
import com.hope.firstsb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zwh
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) throws DataAccessException {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) throws DataAccessException {
        return userMapper.insert(user);
    }

    @Override
    public List<User> getUserList() throws DataAccessException {
        return userMapper.selectUserList();
    }
}
