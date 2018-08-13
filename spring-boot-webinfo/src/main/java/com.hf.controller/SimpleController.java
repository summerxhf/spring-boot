package com.hf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;
import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class SimpleController {
    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping("/WEB-INF-file")
    @ResponseBody
    public String testWebinfo() throws IOException{
        String content = IOUtils.toString(resourceLoader.getResource("classpath:WEB-INF/target_file.txt").getInputStream());
        return "the content of resources:" + content;
    }

    @RequestMapping("/getConnection")
    @ResponseBody
    public String getIsConnected() throws IOException{
//        String content = IOUtils.toString(resourceLoader.getResource("classpath:WEB-INF/target_file.txt").getInputStream());
        return "连接成功!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleController.class,args);
    }
}
