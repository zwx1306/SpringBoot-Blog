package com.ecut.service.impl;

import com.ecut.dao.UserDao;
import com.ecut.domain.User;
import com.ecut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user=userDao.findByUserNameAndPassword(username,password);
        return user;
    }
}
