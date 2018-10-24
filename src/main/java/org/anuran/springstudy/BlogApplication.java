package org.anuran.springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "org.anuran.springstudy")
//@Configuration
public class BlogApplication { //implements WebMvcConfigurer{

	/*@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/templates/");
		irvr.setSuffix(".jsp");
		return irvr;
		
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	/*@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/templates/", ".jsp");
		//registry.jsp();
		WebMvcConfigurer.super.configureViewResolvers(registry);
	}*/
}
