package com.cn.shirly.service.impl;

import com.cn.shirly.dao.MangaDao;
import com.cn.shirly.entity.Follow;
import com.cn.shirly.entity.Manga;
import com.cn.shirly.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    @Autowired
    private MangaDao mangaDao;

    @Override
    public List<Manga> getMangaList(String nom) {
        return mangaDao.getMangaList(nom);
    }

    @Override
    public void addFollow(Follow follow) {
        mangaDao.addFollow(follow);
    }
}
