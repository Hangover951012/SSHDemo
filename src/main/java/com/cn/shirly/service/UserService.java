package com.cn.shirly.service;

import com.cn.shirly.entity.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    User getUserByNameAndPwd(String userName,String passWord);

    List<User> getAllUser();

    void addUser(User user);

    boolean delUser(String id);

    boolean updateUser(User user);
}
