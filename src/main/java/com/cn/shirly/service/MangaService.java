package com.cn.shirly.service;

import com.cn.shirly.entity.Follow;
import com.cn.shirly.entity.Manga;

import java.util.List;

public interface MangaService {

    List<Manga> getMangaList(String nom);

    void addFollow(Follow follow);
}
