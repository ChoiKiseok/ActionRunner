// package com.buk.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// @Configuration
// public class SecrurityConfig {

//   @Bean
//   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//     http.csrf().disable()
//         .authorizeRequests()
//         .antMatchers("/login").permitAll()
//         .antMatchers("/admin/**").authenticated()
//         .and()
//         .formLogin()
//         .usernameParameter("userId")
//         .passwordParameter("userPw")
//         .loginPage("/login")
//         .loginProcessingUrl("/login")
//         .defaultSuccessUrl("/admin/")
//         .permitAll()
//         .and()
//         .logout()
//         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//         .logoutSuccessUrl("/login")
//         .invalidateHttpSession(true);

//     return http.build();
//   }

//   @Bean
//   public WebSecurityCustomizer webSecurityCustomizer() {
//     return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
//   }
// }
