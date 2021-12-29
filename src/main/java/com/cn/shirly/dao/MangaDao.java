package com.cn.shirly.dao;

import com.cn.shirly.entity.Follow;
import com.cn.shirly.entity.Manga;
import com.cn.shirly.entity.User;

import java.util.List;

public interface MangaDao {
    List<Manga> getMangaList(String nom);


    List<Manga> getMangaListByMangaId(List<Integer> id);

    void addFollow(Follow follow);

    List<Follow> getFollowList();

    List<Follow> getFollowListByUserId(int id);
}
