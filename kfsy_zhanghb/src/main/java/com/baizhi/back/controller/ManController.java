package com.baizhi.back.controller;

import com.baizhi.back.service.ManService;
import com.baizhi.common.entity.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/man")
public class ManController {

    @Autowired
    private ManService manService;

    @RequestMapping("/login")
    public String login(HttpSession session, String validate, Man man){
        String code = (String) session.getAttribute("code");

        if(code.equalsIgnoreCase(validate)){
            Man man1 = manService.queryOne(man.getUsername());

            if (man1 != null){
                if(man1.getPassword().equals(man.getPassword())){


                    session.setAttribute("man",man);
                    return "/back/main/main";
                }

            }
        }
        return "back/main/login";
    }
}
