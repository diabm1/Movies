package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

@Configuration
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setConfigLocation(getHibernateConfigFile());
        sessionFactory.setAnnotatedClasses(MovieEntity.class);
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Resource getHibernateConfigFile() {
        return new ClassPathResource("hibernate.cfg.xml");
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(Environment.CONNECTION_PROVIDER, "org.hibernate.connection.C3P0ConnectionProvider");
        return properties;
    }
}



