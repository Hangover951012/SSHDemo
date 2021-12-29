package com.cn.shirly.dao;

import com.cn.shirly.entity.User;

import java.util.List;

public interface UserDao {
    User getUser(String id);

    User getUserByNameAndPwd(String userName,String passWord);

    List<User> getAllUser();

    void addUser(User person);

    boolean delUser(String id);

    boolean updateUser(User user);

}
