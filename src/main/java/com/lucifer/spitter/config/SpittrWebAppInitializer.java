package com.lucifer.spitter.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//使用Java将DispatcherServlet配置在servlet容器中，替代web.xml的配置
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected String[] getServletMappings(){
        return new String[] {"/"};
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }
}
