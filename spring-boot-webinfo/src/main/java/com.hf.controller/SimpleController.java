package com.hf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
@ComponentScan
@EnableAutoConfiguration
public class SimpleController {
    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping("/WEB-INF-file")
    @ResponseBody
    public String testWebinfo() throws IOException{
        Resource resource = resourceLoader.getResource("/WEB-INF/target_file.txt");
        String content="";
        try{
            InputStream is = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                content = content + line;
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return "the webinfo directory of file : " + content;
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleController.class,args);
    }
}
