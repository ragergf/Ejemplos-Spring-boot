package com.innovandotek;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/products").setViewName("products");
		
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/403").setViewName("403");
		registry.addViewController("/error").setViewName("error");
	}
	
}
