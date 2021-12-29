package com.cn.shirly.dao.impl;

import com.cn.shirly.dao.UserDao;
import com.cn.shirly.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUser(String id) {
        String hql = "from User p where p.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        return (User) query.uniqueResult();
    }

    @Override
    public User getUserByNameAndPwd(String userName, String passWord) {
        String hql = "from User p where p.userName=? and p.passWord=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, userName);
        query.setString(1, passWord);
        return (User) query.uniqueResult();
    }

    @Override
    public List<User> getAllUser() {
        String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean delUser(String id) {
        String hql = "delete User p where p.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        return (query.executeUpdate() > 0);
    }

    @Override
    public boolean updateUser(User user) {
        String hql = "update User p set p.name = ? where p.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, user.getUserName());
        query.setString(1, String.valueOf(user.getId()));
        return (query.executeUpdate() > 0);
    }
}
