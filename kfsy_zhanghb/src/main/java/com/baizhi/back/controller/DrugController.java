package com.baizhi.back.controller;

import com.baizhi.back.service.DrugService;
import com.baizhi.common.entity.Drug;
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
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @RequestMapping("/addDrug")
    public Result addUser(Drug drug, MultipartFile file, HttpServletRequest request) throws IOException {
        Result result = new Result();

        String realPath = request.getSession().getServletContext().getRealPath("/back/drug/image");
        String fileName = new Date().getTime()+file.getOriginalFilename();
        File newFile = new File(realPath, fileName);
        file.transferTo(newFile);

        drug.setLogo(fileName);
        try {
            drugService.addOne(drug);
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
            drugService.removeOne(id,request);
            result.setMassage("删除成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMassage("删除失败");
            result.setSuccess(false);
        }
        return  result;
    }

    @RequestMapping("/modifyOne")
    public Result modifyOne(Drug drug){
        Result result = new Result();

        try {
            drugService.modifyOne(drug);
            result.setMassage("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMassage("修改失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/queryOneById")
    public Drug queryOneById(String id){
        Drug drug = drugService.queryOneById(id);
        return drug;
    }

    @RequestMapping("/queryAll")
    public Map queryAll(Integer page , Integer rows){
        return drugService.queryAll(page,rows);
    }

    @RequestMapping("/query")
    public List<Drug> queryAll(){
        return drugService.queryAll();
    }

}
