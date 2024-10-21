package com.example.oj.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author LiChongWei
 * @date 2024/10/17 20:05
 * @description
 */
@Configuration
public class WebConf extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //通过image访问本地的图片
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:\\Barbuda\\Project\\oj-backend\\img\\");
    }
}
