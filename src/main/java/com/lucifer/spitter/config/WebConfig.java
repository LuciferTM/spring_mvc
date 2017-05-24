package com.lucifer.spitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan("com.lucifer.spitter.web")
public class WebConfig extends WebMvcConfigurerAdapter{
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
//        当JSP页面使用JSTL标签时，就需要配置InternalResourceViewResolver来解析JstlView了。
//        JSTL格式化标签需要一个Locale来正确地格式化一些特定语言环境的值，如日期和币种。消息标签可以使用Spring消息源和Locale来正确地选中消息并解析到HTML。
//        要解析JstlView，需要在InternalResourceViewResolver中设置viewClass属性：
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

//XML设置方式
//    <bean id="viewResolver"
//    class="org.springframework.web.servlet.view.InternalResourceViewResolver"
//    p:prefix="/WEB-INF/views/"
//    p:suffix=".jsp" />
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}
