package com.scaler.letmeupdate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Profile("test")
public class TestJpaConfig {


    @Bean
    DataSource dataSource(){
        var datasource=new DriverManagerDataSource();
        datasource.setDriverClassName("org.h2.Driver");
        datasource.setUrl("jdbc:h2:file:./test;DB_CLOSE_DELAY=-1");
        return datasource;
    }
}
