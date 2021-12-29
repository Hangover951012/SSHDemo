package com.cn.shirly.controller;

import com.cn.shirly.entity.User;
import com.cn.shirly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String userName, String passWord, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = userService.getUserByNameAndPwd(userName, passWord);
        if (Objects.isNull(user)) {
            request.setAttribute("pwdmsg", "账号密码不正确");
            return "error";
        }
        session.setAttribute("user", user);
        request.setAttribute("user", user);

        return "search";
    }

    @RequestMapping("/getAllUser")
    public String getAllUser(HttpServletRequest request) {

        request.setAttribute("userList", userService.getAllUser());

        return "/index";
    }

    @RequestMapping("/getUser")
    public String getUser(String id, HttpServletRequest request) {

        request.setAttribute("user", userService.getUser(id));

        return "/editUser";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "/addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user, HttpServletRequest request) {

        userService.addUser(user);

        return "redirect:/getAllUser";
    }

    @RequestMapping("/delUser")
    public void delUser(String id, HttpServletResponse response) {

        String result = "{\"result\":\"error\"}";

        if (userService.delUser(id)) {
            result = "{\"result\":\"success\"}";
        }

        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpServletRequest request) {

        if (userService.updateUser(user)) {
            user = userService.getUser(String.valueOf(user.getId()));
            request.setAttribute("user", user);
            return "redirect:/getAllUser";
        } else {
            return "/error";
        }
    }
}
