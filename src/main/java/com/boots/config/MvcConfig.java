package com.boots.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Initializing which controller binds to which view jsp
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/uploadingAndDownloading").setViewName("uploadingAndDownloading");
        registry.addViewController("/downloading").setViewName("downloading");
        registry.addViewController("/upload").setViewName("upload");
    }
}
