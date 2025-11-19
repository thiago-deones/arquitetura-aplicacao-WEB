import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .authorizeHttpRequests(authorize -> authorize
         .requestMatchers("/v3/api-docs/**","/swagger-ui/**","/actuator/**").permitAll()
         .anyRequest().authenticated()
      )
      .httpBasic(Customizer.withDefaults()); // para dev: basic auth
    return http.build();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
      UserDetails user = User.withDefaultPasswordEncoder()
          .username("admin")
          .password("admin")
          .roles("ADMIN")
          .build();
      return new InMemoryUserDetailsManager(user);
  }
}
