package org.anuran.springstudy.config;

import org.anuran.springstudy.web.interceptors.PageableRequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	private static final Logger log = LoggerFactory.getLogger(WebMvcConfig.class);
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("I am in WebMvcConfig.addInterceptors().." );
		registry.addInterceptor(new PageableRequestInterceptor()).addPathPatterns("/blog/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	

	@Bean
	ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("META-INF/messages/messages");
		return source;
	}
}
