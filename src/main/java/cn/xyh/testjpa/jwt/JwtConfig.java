package cn.xyh.testjpa.jwt;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by xyh on 2019/1/5
 */
@Configuration
public class JwtConfig {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwrFilter filter = new JwrFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }
}
