package ajc.formation.soprasteria.appliSport.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
					.antMatchers(HttpMethod.POST,"/api/client/inscription").anonymous()
					.antMatchers(HttpMethod.POST,"/api/coach/inscription").anonymous()
					.antMatchers(HttpMethod.POST,"/api/exercice/ajouter").hasAnyRole("COACH")
					.antMatchers(HttpMethod.DELETE,"/api/exercice/ajouter").hasAnyRole("COACH")
					.antMatchers(HttpMethod.PUT).permitAll()
					.antMatchers(HttpMethod.DELETE).permitAll()
					.antMatchers(HttpMethod.GET).permitAll()
				//	.antMatchers("/api/exercice/**").hasAnyRole("COACH")
				//	.antMatchers("/api/exercice/**").permitAll()
					.anyRequest().hasAnyRole("COACH")
				.and()
				.httpBasic()
				.and()
				.cors()
				.and()
				.build();
		//@formatter:on		
	}

	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200","https://projet-naaa-frontend.netlify.app") // URLL du front a foutre ici
						.allowedMethods("*");
			}
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
