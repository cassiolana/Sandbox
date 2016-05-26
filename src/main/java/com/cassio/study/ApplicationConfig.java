package com.cassio.study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.walmart.retargeting.gossip.server.rest")
@PropertySource("${properties.file:classpath:version.properties}")
public class ApplicationConfig extends WebMvcConfigurerAdapter {

}
