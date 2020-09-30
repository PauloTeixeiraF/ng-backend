package br.com.novamercado.contracts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 @Override
     protected void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests().antMatchers("/", "/register", "/register/*", "/new-user").permitAll()
         .anyRequest().authenticated()
         .and()
         .formLogin().loginPage("/login").permitAll()
         .and()
         .logout().logoutUrl("/logout").permitAll();

	 http.csrf().disable();
	 http.headers().frameOptions().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	 auth
	         .inMemoryAuthentication()
	         .withUser("admin").password("{noop}admin").roles("ADMIN")
	         .and().withUser("user").password("{noop}user").roles("USER");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}