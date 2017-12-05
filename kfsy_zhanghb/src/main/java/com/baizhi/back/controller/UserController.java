package com.baizhi.back.controller;

import com.baizhi.back.service.UserService;
import com.baizhi.common.entity.Count;
import com.baizhi.common.entity.User;
import com.baizhi.common.util.PoiExcelExport;
import com.baizhi.common.util.PoiUtil;
import com.baizhi.common.util.VaUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/queryAll")
    @ResponseBody
    public Map queryAll(Integer page, Integer rows){
        Map map = userService.selectByPage(page, rows);
        return map;
    }

    @RequestMapping("/update")
    @ResponseBody
    public void update(User user){
        System.out.println(user);
        userService.modifi(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id){
        userService.remove(id);
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    public User queryOne(String id){
        User user = userService.queryUser(id);
        return user;
    }

    @RequestMapping("/image")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {

        //生成验证码
        String code = VaUtils.generateVerifyCode(4);
        //放入session中
        session.setAttribute("code",code);
        //生成验证码图片
        BufferedImage image = VaUtils.getImage(120, 40, code);
        //响应图片到页面
        //设置响应类型
        response.setContentType("image/png");
        ServletOutputStream os = response.getOutputStream();
        //输出图片
        ImageIO.write(image,"png",os);

        //关闭流
        IOUtils.closeQuietly(os);

    }

    @RequestMapping("/echar")
    @ResponseBody
    public Count echar() {
        List<User> users = userService.queryAll();
        Count count = new Count();
        int i = 0;
        int m = 0;
        int n = 0;
        int q = 0;
        int w = 0;
        for (User user : users) {
            Date date = new Date();
            if ((date.getTime() - user.getDate().getTime()) / (24 * 60 * 60 * 1000) <= 7) {
                m = m + 1;
                i++;
            }else if((date.getTime() - user.getDate().getTime()) / (24 * 60 * 60 * 1000) <= 21){
                n = n + 1;
                i++;
            }else if((date.getTime() - user.getDate().getTime()) / (24 * 60 * 60 * 1000) <= 182){
                q = q + 1;
                i++;
            }else if((date.getTime() - user.getDate().getTime()) / (24 * 60 * 60 * 1000) <= 365){
                w = w + 1;
                i++;
            }
        }
        String[] a = new String[i];
        String[] b = new String[i];
        a[0]="一周";
        a[1]="三周";
        a[2]="半年";
        a[3]="一年及以上";
        b[0]= m+"";
        b[1]= n+"";
        b[2]= q+"";
        b[3]= w+"";
        count.setA(a);
        count.setB(b);

        return count;

    }


    @RequestMapping("/copy")
    public void copy(HttpServletResponse response) throws IllegalAccessException, ParseException, IOException {
        List<User> users = userService.queryAll();

        PoiExcelExport poiExcelExport = new PoiExcelExport(response,"所有用户","shee1");
        int titleSize[] = {30, 13, 13, 20, 40, 60, 200};
        //Excel每列所需的属性
        String titleColumn[] = {"id", "phone", "username", "password", "salt", "state", "date"};
        //Excel每列表头显示的文本
        String titleName[] = {"编号","电话", "用户名", "密码", "私盐", "状态", "注册时间"};

        poiExcelExport.wirteExcel(titleColumn,titleName,titleSize,users);
        System.out.println("备份成功！！" + new Date());
    }

    @Scheduled(cron = " * 0/10 * * * ?")
    public void copy1() throws Exception{
        List<User> users = userService.queryAll();

        PoiUtil.exportExcel(User.class,users,"d://IDEA//users.xls");

        System.out.println("备份成功！！" + new Date());
    }
}
