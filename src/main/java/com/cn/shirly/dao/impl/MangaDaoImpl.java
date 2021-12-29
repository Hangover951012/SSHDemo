package com.cn.shirly.dao.impl;

import com.cn.shirly.dao.MangaDao;
import com.cn.shirly.entity.Follow;
import com.cn.shirly.entity.Manga;
import com.cn.shirly.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MangaDaoImpl implements MangaDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Manga> getMangaList(String nom) {
        String hql = "from Manga p where p.nom like ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, "%" + nom + "%");
        return query.list();
    }

    @Override
    public List<Manga> getMangaListByMangaId(List<Integer> id) {
        String hql = "from Manga p where p.id in (:ids)";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameterList("ids",id);
        return query.list();
    }

    @Override
    public void addFollow(Follow follow) {
        String sql = "insert into Follow (idUser,idManga)  values(?,?)";
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.setInteger(0, follow.getIdUser());
        query.setInteger(1, follow.getIdManga());
        query.executeUpdate();
    }

    @Override
    public List<Follow> getFollowList() {
        String hql = "from Follow";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Follow> getFollowListByUserId(int id) {
        String hql = "from Follow p where p.idUser=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0, id);
        return query.list();
    }
}
