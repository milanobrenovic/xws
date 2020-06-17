package com.xws.tim12.config;

import com.xws.tim12.security.TokenUtils;
import com.xws.tim12.security.auth.RestAuthenticationEntryPoint;
import com.xws.tim12.security.auth.TokenAuthenticationFilter;
import com.xws.tim12.serviceImpl.AdminServiceImpl;
import com.xws.tim12.serviceImpl.AgentServiceImpl;
import com.xws.tim12.serviceImpl.NormalUserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminServiceImpl jwtAdminDetailsService;

    @Autowired
    private NormalUserServiceImpl jwtUserDetailsService;

    @Autowired
    private AgentServiceImpl jwtAgentDetailsService;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private TokenUtils tokenUtils;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtAdminDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(jwtAgentDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(restAuthenticationEntryPoint)
            .and()
            .authorizeRequests()
            .antMatchers("/api/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .cors()
            .and()
            .addFilterBefore(
            		new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService),
            		BasicAuthenticationFilter.class
            		)
            
            .addFilterBefore(
                    new TokenAuthenticationFilter(tokenUtils, jwtAdminDetailsService),
                    BasicAuthenticationFilter.class
            )
            .addFilterBefore(
                    new TokenAuthenticationFilter(tokenUtils, jwtAgentDetailsService),
                    BasicAuthenticationFilter.class
            );

        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST, "/api/**");
      //  web.ignoring().antMatchers(HttpMethod.POST, "/**");
        web.ignoring().antMatchers(HttpMethod.PUT, "/api/auth");
        web.ignoring().antMatchers(HttpMethod.POST, "/register");
        web.ignoring().antMatchers(HttpMethod.POST, "/incrementNumberOfAdds/**");
    }

}
