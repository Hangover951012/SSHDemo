package com.cn.shirly.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class HibernateUtil {
    @Autowired
    private  SessionFactory sessionFactory;

    public  Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
