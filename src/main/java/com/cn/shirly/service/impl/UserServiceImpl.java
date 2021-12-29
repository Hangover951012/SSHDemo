package com.cn.shirly.service.impl;

import com.cn.shirly.dao.UserDao;
import com.cn.shirly.entity.User;
import com.cn.shirly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public User getUserByNameAndPwd(String userName, String passWord) {
        return userDao.getUserByNameAndPwd(userName,passWord);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public boolean delUser(String id) {
        return userDao.delUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}
