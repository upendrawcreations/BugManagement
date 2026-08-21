package com.cineflow.bug.config;

import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean SecurityFilterChain security(HttpSecurity http) throws Exception {
    return http.csrf(c -> c.disable()).cors(Customizer.withDefaults())
        .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(a -> a.requestMatchers("/actuator/health", "/actuator/health/**", "/actuator/info", "/actuator/prometheus", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll().anyRequest().authenticated())
        .oauth2ResourceServer(o -> o.jwt(j -> {})).build();
  }
  @Bean JwtDecoder jwtDecoder(@Value("${app.jwt.secret}") String secret) {
    return NimbusJwtDecoder.withSecretKey(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256")).build();
  }
}
