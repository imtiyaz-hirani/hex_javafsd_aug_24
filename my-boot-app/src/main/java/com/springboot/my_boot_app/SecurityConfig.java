package com.springboot.my_boot_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.springboot.my_boot_app.service.SecurityUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private SecurityUserService securityUserService; 
	
	@Bean
	 SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http               
                .authorizeHttpRequests(authorize -> authorize
                				.requestMatchers(HttpMethod.GET, "/auth/login").authenticated()
                				.requestMatchers(HttpMethod.GET, "/project/employee/stat").permitAll()
                                .requestMatchers(HttpMethod.POST, "/employee/add").hasAuthority("MANAGER")
                                .requestMatchers(HttpMethod.GET, "/employee/one/{eid}").hasAuthority("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/employee/all").authenticated()
                                .requestMatchers(HttpMethod.GET, "/project/employee/{eid}").hasAnyAuthority("EMPLOYEE", "MANAGER")
                                .requestMatchers(HttpMethod.GET, "/manager/employee").hasAuthority("MANAGER")

                                .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(securityUserService);
		authenticationProvider.setPasswordEncoder(getEncoder());
		 
		return new ProviderManager(authenticationProvider);
	}
	
	@Bean 
	PasswordEncoder getEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}

/*   
 *    PasswordEncoder 
 *         | 
 * BcryptPasswordEncoder 
 * 
 * 
 */