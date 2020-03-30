package com.zzc.controller;

import com.zzc.entity.User;
import com.zzc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/index")
    public String insert(User user){
        userService.insert(user);
        return "index";
    }

    @GetMapping("/list")
    public String select(Model model){
        List<User> userList =  userService.selectAll();
        model.addAttribute("list",userList);
        return "index";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "user/reg";
    }

    @RequestMapping("/forget")
    public String forget(){
        return "user/forget";
    }


    //用户登录
    @RequestMapping("/logining")
    public String userLogin(User user, Model model, HttpServletRequest request) {
        User loginUser = userService.login(user);
        if (loginUser == null) {
            model.addAttribute("login_err", "用户名或密码错误!");
            //跳转到当前登录页面
            return "user/login";
        }
        request.getSession().setAttribute("user", loginUser);
        return "index";
    }

}
