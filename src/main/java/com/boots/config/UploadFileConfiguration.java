package com.boots.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class UploadFileConfiguration {

    /**
     * File upload configuration
     * @return  null
     */
        @Bean
        public MultipartConfigElement multipartConfigElement(){
            MultipartConfigFactory factory = new MultipartConfigFactory();
            // Set a file size limit. Exceeding the setup page will cause an exception message
            //factory.setMaxFileSize(DataSize.parse("256KB"));
            // Set total upload file size
            //factory.setMaxRequestSize(DataSize.parse("512KB"));
            return factory.createMultipartConfig();
        }

    }



