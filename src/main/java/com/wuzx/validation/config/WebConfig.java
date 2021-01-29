package com.wuzx.validation.config;

import com.wuzx.validation.security.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String API_PATTERN = "/API/**";

    @Bean
    public CorsFilter corsFilter() {
        // 跨域设置
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(API_PATTERN, buildConfig());
        return new CorsFilter(source);
    }
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加登录、权限拦截器，并排除登录接口
        registry.addInterceptor(loginInterceptor()).addPathPatterns(API_PATTERN).excludePathPatterns("/API/user");
    }
    @Bean
    public LoginInterceptor loginInterceptor() {return new LoginInterceptor();}
}
