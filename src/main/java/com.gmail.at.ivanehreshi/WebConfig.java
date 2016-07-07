package com.gmail.at.ivanehreshi;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.gmail.at.ivanehreshi.controllers")
public class WebConfig extends WebMvcConfigurerAdapter implements InitializingBean {
    @Autowired
    RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * Check RedirectController before and after this
         */
        requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
    }
}
