package com.example.project.config;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.security.SecureRandom;
import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailService customUserDetailService;

    public SecurityConfig(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }

    //비밀번호 암호화
    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securyFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/login","/join/**","/popup/**").anonymous() //인증되지 않은 사용자 접근 허용
                    .requestMatchers("/","/api/jusopopup.html","/join.html").permitAll() //모든 사용자 접근 허용
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() //모든 사용자 접근 허용
                    .anyRequest().authenticated()) //인증된 사용자만 접근 허용
                .formLogin((form) -> form
                     .loginPage("/login") //로그인 페이지 설정
                     .defaultSuccessUrl("/", true) //인증 성공 시 루트로 이동
                     .permitAll()) //로그인 프로세스관련 설정
                .logout((logout) -> logout
                        .logoutUrl("/logout") //로그아웃 url
                        .logoutSuccessUrl("/") //성공 시 루트로 이동
                        .invalidateHttpSession(true) //성공 시 로그아웃 현재 세션 무효화
                        .deleteCookies("JSESSIONID") //쿠키 삭제
                        .permitAll())
                .csrf(AbstractHttpConfigurer::disable); //CSRF 보호 기능 비활성화
                /*
                .exceptionHandling(except-> except //예외 관련 설정
                        .authenticationEntryPoint((request, response, authException) -> {
                            //인증되지 않은 사용자가 보호된 리소스에 접근하려고 할 때 발생하는 예외
                            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) { //AJAX 요청인지 확인
                                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                                //AJAX 요청이라면 자동으로 로그인페이지로 이동하지 않고, 오류코드 반환
                            } else {
                                response.sendRedirect("/login"); //AJAX 요청이 아니라면 login페이지로 이동
                            }
                        }))*/

        return httpSecurity.build();
    }

    @Value("${primary.key}")
    private String key;

    @Bean
    public AesBytesEncryptor aesBytesEncryptor() {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return new AesBytesEncryptor(key, Hex.encodeHexString(salt));
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { //사용자 인증 관리
        auth.userDetailsService(customUserDetailService).passwordEncoder(bCryptPasswordEncoder());
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // fixme: cors.setAllowedOrigins(Arrays.asList("<YOUR_DOMAIN>")); // 예: "https://your-ios-app.com"
        configuration.setAllowedOrigins(Arrays.asList("*","http://api.kcisa.kr"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Content-Type", "Authorization", "X-XSRF-token"));
        configuration.setAllowCredentials(false);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
