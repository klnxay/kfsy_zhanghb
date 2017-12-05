package com.baizhi.back.controller;

import com.baizhi.back.service.ProductService;
import com.baizhi.common.entity.Product;
import com.baizhi.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/addProduct")
    @ResponseBody
    public Result addProduct(Product product){
        Result result = new Result();

        try {
            productService.insert(product);
            result.setMassage("添加成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMassage("添加失败");
            result.setSuccess(false);
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/removeOne")
    @ResponseBody
    public Result removeOne(String id){
        Result result = new Result();
        try {
            productService.delete(id);
            result.setMassage("删除成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMassage("删除失败");
            result.setSuccess(false);
        }
        return  result;
    }

    @RequestMapping("/modifyOne")
    @ResponseBody
    public Result modifyOne(Product product){
        Result result = new Result();

        try {
            productService.update(product);
            System.out.println(product);
            result.setMassage("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMassage("修改失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/queryOneById")
    @ResponseBody
    public Product queryOneById(String id){
        Product product = productService.queryOne(id);
        return product;
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Product> queryAll(Integer page , Integer rows){
        return productService.queryAll();
    }

    @RequestMapping("/editPimg")
    @ResponseBody
    public Result editPimg(String id , MultipartFile file , HttpServletRequest request) throws IOException {
        Result result = new Result();
        String realPath = request.getSession().getServletContext().getRealPath("/back/product/image");
        String fileName = new Date().getTime()+file.getOriginalFilename();
        File newFile = new File(realPath, fileName);
        file.transferTo(newFile);
        Product product = productService.queryOne(id);
        String image = product.getImage();
        new File(realPath,image).delete();
        product.setImage(fileName);

        try {
            productService.update(product);
            result.setMassage("修改成功");
            result.setSuccess(true);
        } catch (Exception e) {
            newFile.delete();
            result.setMassage("修改失败");
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

}
