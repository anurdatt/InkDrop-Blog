package org.anuran.springstudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http
			//.authorizeRequests()
/*			.antMatchers("/resources/**", "/login.jsp*")
			.access("hasRole('IS_AUTHENTICATED_ANONYMOUSLY')")*/
			//.antMatchers("/**/secure/**")
			//.hasRole("USER")
		//.anyRequest()
		//	.permitAll()
			//.and()
		/*.formLogin()
			.loginPage("/login.jsp")
			.permitAll()
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/");*/
			
		http.authorizeRequests()
		.antMatchers("/**/secure/**").hasRole("ADMIN")
		.antMatchers("/**").permitAll()
		//.and()
		//.formLogin().permitAll()
		.and()
		.logout().permitAll()
		//.invalidateHttpSession(true)
		//.logoutUrl("/logout")
		.logoutSuccessUrl("/")
		;
		
		super.configure(http);
	}
	

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("anuran").password("{noop}password")
		.roles("ADMIN");
		
		
	}
	
	
}
