package com.cdac.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception{
	 * auth.inMemoryAuthentication().withUser("admin").password("admin123").roles(
	 * "ADMIN");
	 * auth.inMemoryAuthentication().withUser("hospital").password("hospital123").
	 * roles("HOSPITAL"); }
	 */
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable();
	 /* http.authorizeRequests().antMatchers("admin/*").hasAnyRole("ADMIN").
	 * anyRequest().fullyAuthenticated().and(). httpBasic();
	 */
		  /* * http.authorizeRequests().antMatchers("hospital/addblood").hasAnyRole(
		 * "HOSPITAL").anyRequest().fullyAuthenticated().and(). httpBasic();
		 * http.authorizeRequests().antMatchers("hospital/addoxygen").hasAnyRole(
		 * "HOSPITAL").anyRequest().fullyAuthenticated().and(). httpBasic();
		 * http.authorizeRequests().antMatchers("hospital/adddoctor").hasAnyRole(
		 * "HOSPITAL").anyRequest().fullyAuthenticated().and(). httpBasic();
		 */
	  }
	 
			/*
			 * @Bean public static NoOpPasswordEncoder passwordEncoder() { return
			 * (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance(); }
			 */
	
}