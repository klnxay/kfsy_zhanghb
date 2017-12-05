package com.baizhi.back.controller;

import com.baizhi.back.service.ImageService;
import com.baizhi.common.entity.Image;
import com.baizhi.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/addImage")
    public Result addImage(Image image, MultipartFile file, HttpServletRequest request) throws IOException {
        Result result = new Result();
        String realPath = request.getSession().getServletContext().getRealPath("/back/image/image");
        String fileName = new Date().getTime()+file.getOriginalFilename();
        File newFile = new File(realPath, fileName);
        file.transferTo(newFile);
        image.setImage(fileName);

        try {
            imageService.addOne(image);
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
            imageService.removeOne(id,request);
            result.setMassage("删除成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMassage("删除失败");
            result.setSuccess(false);
        }
        return  result;
    }

    @RequestMapping("/modifyOne")
    public Result modifyOne(Image image){
        Result result = new Result();

        try {
            imageService.modifyOne(image);
            result.setMassage("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMassage("修改失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/queryOneById")
    public Image queryOneById(String id){
        Image image = imageService.queryOneById(id);
        return image;
    }

    @RequestMapping("/queryAll")
    public Map queryAll(Integer page , Integer rows){
        return imageService.queryAll(page,rows);
    }

}
