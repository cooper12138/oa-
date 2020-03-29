package com.zzc.controller;

import com.zzc.entity.User;
import com.zzc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping({"/", "index", "/index.html"})
    public String index(){
        return "user/login";
    }

    @GetMapping("/login")
    public String toLogin(Model model){
        return "user/login";
    }

    @RequestMapping("/logining")
    @ResponseBody
    public String logining(Model model, HttpSession session, String username, String password){
        User user = indexService.login(username, password);
        if(user == null){
            model.addAttribute("user","用户名密码错误！");
            return "user/login";
        }
        session.setAttribute("user",user);

        return "common/index";
    }


}
