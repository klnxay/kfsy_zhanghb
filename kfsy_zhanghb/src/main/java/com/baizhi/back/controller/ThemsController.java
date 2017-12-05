package com.baizhi.back.controller;

import com.baizhi.back.service.ThemsService;
import com.baizhi.common.entity.Result;
import com.baizhi.common.entity.Thems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/thems")
public class ThemsController {

    @Autowired
    private ThemsService themsService;

    @RequestMapping("/addThems")
    public Result addThems(Thems thems , MultipartFile file, HttpServletRequest request) throws IOException {
        Result result = new Result();

        String realPath = request.getSession().getServletContext().getRealPath("/back/thems/image");
        String fileName = new Date().getTime()+file.getOriginalFilename();
        File newFile = new File(realPath, fileName);
        file.transferTo(newFile);

        thems.setImage(fileName);

        try {
            themsService.addOne(thems);
            result.setMassage("添加成功");
            result.setSuccess(true);
        } catch (Exception e) {
            newFile.delete();
            result.setMassage("添加失败");
            result.setSuccess(false);
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/removeOne")
    public Result removeOne(String id,HttpServletRequest request){
        Result result = new Result();
        try {
            themsService.removeOne(id,request);
            result.setMassage("删除成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMassage("删除失败");
            result.setSuccess(false);
        }
        return  result;
    }

    @RequestMapping("/modifyOne")
    public Result modifyOne(Thems thems){
        Result result = new Result();

        try {
            themsService.modifyOne(thems);
            result.setMassage("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMassage("修改失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/queryOneById")
    public Thems queryOneById(String id){
        Thems thems = themsService.queryOneById(id);
        return thems;
    }

    @RequestMapping("/queryAll")
    public Map queryAll(Integer page , Integer rows){
        return themsService.queryAll(page,rows);
    }

    @RequestMapping("/query")
    public List<Thems> queryAll(){
        return themsService.queryAll();
    }

}
