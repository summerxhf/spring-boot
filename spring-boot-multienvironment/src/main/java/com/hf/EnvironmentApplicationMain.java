package com.hf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class EnvironmentApplicationMain {

    @Autowired
    private Environment env;

    @RequestMapping("/env")
    public Map<String, Object> env() throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("config", env.getProperty("com.hf.blog.name"));
        return map;

    }

    public static void main(String[] args) {
        SpringApplication.run(EnvironmentApplicationMain.class,args);
    }

}
