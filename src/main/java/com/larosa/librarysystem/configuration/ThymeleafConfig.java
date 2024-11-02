//package com.larosa.librarysystem.configuration;
//
//
//import nz.net.ultraq.thymeleaf.LayoutDialect;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//
//@Configuration
//public class ThymeleafConfig {
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.addDialect(new LayoutDialect());
//        return templateEngine;
//    }
//
//    @Bean
//    public SpringWebMvcThymeleafViewResolver viewResolver() {
//        SpringWebMvcThymeleafViewResolver resolver = new SpringWebMvcThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        resolver.setCharacterEncoding("UTF-8");
//        resolver.setOrder(1); // Ensure this resolver has precedence
//        return resolver;
//    }
//}
