package com.baizhi.back.controller;

import com.baizhi.back.service.PimageService;
import com.baizhi.common.entity.Pimage;
import com.baizhi.common.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/pimage")
public class PimageController {

    @Resource
    private PimageService pimageService;

    @RequestMapping("/addPimage")
    public Result addAddress(Pimage pimage, MultipartFile file, HttpServletRequest request) throws IOException {
        Result result = new Result();
        String realPath = request.getSession().getServletContext().getRealPath("/back/pimage/image");
        String fileName = new Date().getTime()+file.getOriginalFilename();
        File newFile = new File(realPath, fileName);
        file.transferTo(newFile);

        pimage.setImage(fileName);

        try {
            pimageService.addOne(pimage);
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
            pimageService.removeOne(id,request);
            result.setMassage("删除成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMassage("删除失败");
            result.setSuccess(false);
        }
        return  result;
    }

    @RequestMapping("/modifyOne")
    public Result modifyOne(Pimage pimage,MultipartFile file, HttpServletRequest request) throws IOException {
        Result result = new Result();

        String realPath = request.getSession().getServletContext().getRealPath("/back/pimage/image");
        String fileName = new Date().getTime()+file.getOriginalFilename();
        File newFile = new File(realPath, fileName);
        file.transferTo(newFile);

        pimage.setImage(fileName);


        try {
            pimageService.modifyOne(pimage);
            result.setMassage("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMassage("修改失败");
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/queryOneById")
    public Pimage queryOneById(String id){
        Pimage pimage = pimageService.queryOneById(id);
        return pimage;
    }

    @RequestMapping("/queryAll")
    public Map queryAll(Integer page , Integer rows){
        return pimageService.queryAll(page,rows);
    }

    @RequestMapping("/update")
    public Result update(Pimage pimage){
        Result result = new Result();
        try {
            pimageService.modifyOne(pimage);
            result.setMassage("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMassage("修改失败");
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }
}
