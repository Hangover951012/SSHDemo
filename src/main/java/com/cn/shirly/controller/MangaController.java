package com.cn.shirly.controller;

import com.cn.shirly.dao.MangaDao;
import com.cn.shirly.entity.Follow;
import com.cn.shirly.entity.Manga;
import com.cn.shirly.entity.User;
import com.cn.shirly.service.MangaService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @Autowired
    private MangaDao mangaDao;

    @RequestMapping("/getAllManga")
    public String getAllUser(String nom, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(nom == null){
            nom = "";
        }
        List<Manga> mangaList = mangaService.getMangaList(nom);
        List<Follow> followList = mangaDao.getFollowList();
        if (CollectionUtils.isNotEmpty(mangaList) && CollectionUtils.isNotEmpty(followList)) {

            mangaList.forEach(manga -> {
                followList.forEach(follow -> {
                    if(user.getId() == follow.getIdUser()){
                        if (manga.getId() == follow.getIdManga()) {
                            manga.setStatus("1");
                        }
                    }
                });
            });

        }
        request.setAttribute("mangaList", mangaList);
        return "manhua";
    }

    @RequestMapping("/followManga")
    public String followManga(String id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 存关系
        Follow follow = new Follow();
        follow.setIdManga(Integer.valueOf(id));
        follow.setIdUser(user.getId());
        mangaDao.addFollow(follow);

        return "redirect:/getAllManga";
    }

    @RequestMapping("/followMangaList")
    public String followMangaList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Manga> mangaListByMangaId = new ArrayList<>();

        // 查询关系
        List<Follow> followListByUserId = mangaDao.getFollowListByUserId(user.getId());
        if(CollectionUtils.isNotEmpty(followListByUserId)){
            List<Integer> mangaId = followListByUserId.stream().map(follow -> follow.getIdManga()).collect(Collectors
                    .toList());
            mangaListByMangaId = mangaDao.getMangaListByMangaId(mangaId);
        }
        request.setAttribute("mangaList", mangaListByMangaId);

        return "follow";
    }


}
