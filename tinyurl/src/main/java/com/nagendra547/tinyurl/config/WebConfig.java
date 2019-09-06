package com.nagendra547.tinyurl.config;
import javax.servlet.http.HttpServlet;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author nagendra
 *
 */
@Configuration
public class WebConfig {
    @Bean
    ServletRegistrationBean<HttpServlet> h2servletRegistration(){
        ServletRegistrationBean<HttpServlet> registrationBean = new ServletRegistrationBean<HttpServlet>( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
