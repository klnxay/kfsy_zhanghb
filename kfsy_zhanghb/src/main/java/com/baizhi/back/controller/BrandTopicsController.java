package com.baizhi.back.controller;

import com.baizhi.back.service.BrandTopicsService;
import com.baizhi.common.entity.BrandTopics;
import com.baizhi.common.entity.Result;
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
@RequestMapping("/brand")
public class BrandTopicsController {

    @Autowired
    private BrandTopicsService brandTopicsService;

    @RequestMapping("/addBrand")
    public Result addBrand(BrandTopics brandTopics, MultipartFile small, MultipartFile big, HttpServletRequest request) throws IOException {
        Result result = new Result();

        String realPath = request.getSession().getServletContext().getRealPath("/back/brand/image");

        String sfileName = new Date().getTime()+small.getOriginalFilename();
        File snewFile = new File(realPath, sfileName);

        String bfileName = new Date().getTime()+big.getOriginalFilename();
        File bnewFile = new File(realPath, bfileName);

        small.transferTo(snewFile);
        brandTopics.setImage(sfileName);
        big.transferTo(bnewFile);
        brandTopics.setUrlimage(bfileName);

        try {
            brandTopicsService.addOne(brandTopics);
            result.setMassage("添加成功");
            result.setSuccess(true);
        } catch (Exception e) {
            //删除 已经 上传 的两张图
            snewFile.delete();
            bnewFile.delete();
            result.setMassage("添加失败成功");
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("/removeOne")
    public Result removeOne(String id,HttpServletRequest request){
        Result result = new Result();
        try {
            brandTopicsService.removeOne(id,request);
            result.setMassage("删除成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMassage("删除失败");
            result.setSuccess(false);
        }
        return  result;
    }


    @RequestMapping("/modifyOne")
    public Result modifyOne(BrandTopics brandTopics){
        Result result = new Result();

        try {
            brandTopicsService.modifyOne(brandTopics);
            result.setMassage("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMassage("修改失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/queryOneById")
    public BrandTopics queryOneById(String id){
        BrandTopics brandTopics = brandTopicsService.queryOneById(id);
        return brandTopics;
    }

    @RequestMapping("/queryAll")
    public Map queryAll(Integer page,Integer rows){
        return brandTopicsService.queryAll(page,rows);
    }

    @RequestMapping("/query")
    public List<BrandTopics> queryAll(){
        return brandTopicsService.queryAll();
    }

}
