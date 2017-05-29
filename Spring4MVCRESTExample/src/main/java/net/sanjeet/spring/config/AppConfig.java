package net.sanjeet.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/*
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.sanjeet.spring")*/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="net.sanjeet.spring")
public class AppConfig {

}
