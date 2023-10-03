package pe.edu.upc.aaw.ep_ejercicio1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    private JwtAuthenticationEntryPoint jmtrJwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jmtrJwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jmtrJwtRequestFilter;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver jmtrExceptionResolver;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration jmtrAuthenticationConfiguration) throws Exception {
        return jmtrAuthenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder jmtrAuth) throws Exception {
        jmtrAuth.userDetailsService(jmtrJwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity jmtrHttpSecurity) throws Exception {
        jmtrHttpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()//.hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jmtrJwtAuthenticationEntryPoint)
                .and()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        jmtrHttpSecurity.addFilterBefore(jmtrJwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return jmtrHttpSecurity.build();
    }
}
