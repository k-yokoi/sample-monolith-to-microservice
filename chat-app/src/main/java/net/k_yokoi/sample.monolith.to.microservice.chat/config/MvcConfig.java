package net.k_yokoi.sample.monolith.to.microservice.chat.config;

import net.k_yokoi.sample.monolith.to.microservice.chat.app.web.interceptor.MenuSetInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("net.k_yokoi.sample.monolith.to.microservice.chat.app.web")
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public MenuSetInterceptor menuSetInterceptor(){
        return new MenuSetInterceptor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(menuSetInterceptor());
    }

}
