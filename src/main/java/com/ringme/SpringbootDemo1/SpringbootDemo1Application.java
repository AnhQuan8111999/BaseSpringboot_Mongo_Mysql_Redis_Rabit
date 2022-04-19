package com.ringme.SpringbootDemo1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.ringme.SpringbootDemo1.service.UserLoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class SpringbootDemo1Application /*extends WebSecurityConfigurerAdapter*/ {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo1Application.class, args);
	}




	//	@Autowired
//	UserLoginService userLoginService;
/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().permitAll().antMatchers("/mysql").hasAnyRole("ADMIN").anyRequest().authenticated().and().
		formLogin().loginPage("/login").defaultSuccessUrl("/mysql/view").failureUrl("/login?e=error").permitAll().and().exceptionHandling().accessDeniedPage("/login?e=error");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**","/img/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userLoginService);
	}
	*/

}
