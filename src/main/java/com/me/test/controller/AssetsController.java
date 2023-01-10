package com.me.test.controller;

import com.alibaba.fastjson.JSON;
import com.me.test.pojo.Assets;
import com.me.test.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller 控制层需要的注解
//@RestController 使用这个也是可以的，但是使用后他里面所有请求返回的都是字符串！
//一般只需要作为接口放回JSON格式数据的话推荐使用@RestController
//@Controller这个是可以与Thymeleaf模板引擎使用时可以返回一个页面的
@Controller
//@RequestMapping指定路径名
@RequestMapping(value = "/assets")
public class AssetsController {
    //获取到UserInfoService
    @Autowired
    private AssetsService assetsService;

    //Get请求
    @GetMapping
    //@ResponseBody 注释后表示放回的是字符串
    @ResponseBody
    public String queryAll(){
        List<Assets> userInfoList = assetsService.queryAll();
        return JSON.toJSONString(userInfoList);
    }

    //使用了RestFull风格
    @GetMapping("/{id}")
    @ResponseBody
    public String query(@PathVariable(value = "id")Integer id){
        Assets assets = assetsService.queryById(id);
        List<Assets> assetsList = new ArrayList<>();
        assetsList.add(assets);
        return JSON.toJSONString(assets);
    }

    //post请求
    //@RequestBody 表示接受请求的JSON格式的数据
    @PostMapping
    @ResponseBody
    public String add(@RequestBody Assets assets){
        assetsService.add(assets);
        return "添加OK";
    }

    //Delete请求
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public String delete(@PathVariable("id")Integer id){
        assetsService.delete(id);
        return "删除成功";
    }

    //Put请求
    @PutMapping("/{id}")
    @ResponseBody
    public String update(@PathVariable("id")Integer id,
            @RequestBody Assets assets){
        assets.setId(id);
        assetsService.update(assets);
        return "修改成功";
    }
}
