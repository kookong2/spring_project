package org.study.configs;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
                .usernameParameter("userId")
                .passwordParameter("userPw")
                .failureUrl("/user/login?success=false")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/");

        http.authorizeHttpRequests()
                .requestMatchers("/", "/user", "/user/login", "/error/**").permitAll()
                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated();

        /**
         *  관리자 페이지에 권한없는 요청 URL 접속시 401 코드 및 오류 페이지 이동
         *  그 외에는 로그인 페이지로 이동
         */
        http.exceptionHandling()
                .authenticationEntryPoint((req, res, e) -> {

                    String redirectUrl = "/user/login";
                    String URI = req.getRequestURI();
                    if (URI.indexOf("/admin") != -1) {
                        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        redirectUrl = "/error/401";
                    }

                    res.sendRedirect(req.getContextPath() + redirectUrl);
                });

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return w -> w.ignoring()
                .requestMatchers(
                        "/front/images/**",
                            "/mobile/images/**",
                            "/admin/images/**",
                            "/front/js/**",
                            "/mobile/js/**",
                            "/admin/js/**",
                            "/front/css/**",
                            "/mobile/css/**",
                            "/admin/css/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}