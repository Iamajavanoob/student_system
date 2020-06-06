package com.li.back.controller;
import java.util.*;

import com.li.back.jwt.tool;
import com.li.back.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class UserHandler {

    @RequestMapping("/get")
    public String get(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(User user){
        if (user.equals(new User(1234,4321,null))){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("first",123);
            user.setAdmin(tool.createToken(map));
        }
        return user.getAdmin();
    }
}
