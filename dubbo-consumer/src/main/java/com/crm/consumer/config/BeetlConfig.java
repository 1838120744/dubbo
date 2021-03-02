package com.crm.consumer.config;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.IOException;

@Configuration
public class BeetlConfig {

    //Beetl配置类
    @Bean(name = "beetlConfigurer")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration(){
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration=new BeetlGroupUtilConfiguration();
        ResourcePatternResolver patternResolver= ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        try{
            WebAppResourceLoader webAppResourceLoader=new WebAppResourceLoader(patternResolver.getResource("classpath:/").getFile().getPath());
            beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        beetlGroupUtilConfiguration.init();
        return beetlGroupUtilConfiguration;
    }

    //Beetl视图解析类
    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResoler(@Qualifier("beetlConfigurer") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration){
        BeetlSpringViewResolver beetlSpringViewResolver=new BeetlSpringViewResolver();
        beetlSpringViewResolver.setPrefix("/templates/");
        beetlSpringViewResolver.setSuffix(".html");
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }
}
