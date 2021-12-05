package com.senla.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@ComponentScan("com.senla")
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {
}
