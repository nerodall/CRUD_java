package ru.gb.my_first_crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.my_first_crud.aspect.LoggingAspect;


@Configuration
@ComponentScan(basePackages = "ru.gb")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public LoggingAspect aspect()
    {
        return new LoggingAspect();
    }
}