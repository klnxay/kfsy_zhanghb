package com.baizhi.back.controller;

import com.baizhi.back.service.TypeService;
import com.baizhi.common.entity.Result;
import com.baizhi.common.entity.Type;
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
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/addType")
    public Result addAddress(Type type, MultipartFile file, HttpServletRequest request) throws IOException {
        Result result = new Result();
        String realPath = request.getSession().getServletContext().getRealPath("/back/type/image");
        String fileName = new Date().getTime()+file.getOriginalFilename();
        File newFile = new File(realPath, fileName);
        file.transferTo(newFile);

        type.setImage(fileName);

        try {
            typeService.addOne(type);
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
            typeService.removeOne(id,request);
            result.setMassage("删除成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMassage("删除失败");
            result.setSuccess(false);
        }
        return  result;
    }

    @RequestMapping("/modifyOne")
    public Result modifyOne(Type type){
        Result result = new Result();

        try {
            typeService.modifyOne(type);
            result.setMassage("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMassage("修改失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/queryOneById")
    public Type queryOneById(String id){
        Type type = typeService.queryOneById(id);
        return type;
    }

    @RequestMapping("/queryAll")
    public Map queryAll(Integer page , Integer rows){
        return typeService.queryAll(page,rows);
    }

    @RequestMapping("/query")
    public List<Type> queryAll(){
        return typeService.queryAll();
    }

}
