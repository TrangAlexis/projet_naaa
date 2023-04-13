package ajc.formation.soprasteria.appliSport.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApiSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//@formatter:off
		return http.antMatcher("/api/**")
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.POST,"/api/client").anonymous()
//					.antMatchers(HttpMethod.POST, "/api/client").hasAnyRole("CLIENTFREEMIUM")
					.antMatchers(HttpMethod.GET).permitAll()
					.anyRequest().hasAnyRole("ADMIN")
				.and()
				.httpBasic()
				.and()
				.build();
		//@formatter:on		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
