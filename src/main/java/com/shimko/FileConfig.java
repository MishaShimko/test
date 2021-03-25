package com.shimko;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.MultipartConfigElement;

/**
 * @author Shimko
 * @date 25.03.2021
 * @time 23:19
 */
@Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
public class FileConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        multipartConfigFactory.setMaxFileSize("15MB");
        multipartConfigFactory.setMaxRequestSize("25MB");
        return multipartConfigFactory.createMultipartConfig();
    }
}

